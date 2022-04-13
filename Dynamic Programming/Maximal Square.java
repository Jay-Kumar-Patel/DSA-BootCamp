class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = 0;
        HashMap<String,Integer> memo = new HashMap<>();
        
        for(int currRow=0;currRow<m;currRow++){
            for(int currCol=0;currCol<n;currCol++){
                int temp = maxSquare(currRow,currCol,m,n,memo,matrix);
                ans = Math.max(ans,temp*temp);
            }
        }
        
        return ans;
    }
    
    private int maxSquare(int currRow, int currCol, int m, int n, HashMap<String,Integer> memo, char[][] matrix){
        
        if(currRow>=m || currCol>=n || matrix[currRow][currCol]=='0')
            return 0;
        
        String currentKey = currRow + "-" + currCol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int right = 1 + maxSquare(currRow,currCol+1,m,n,memo,matrix);
        int diagonal = 1 + maxSquare(currRow+1,currCol+1,m,n,memo,matrix);
        int bottom = 1 + maxSquare(currRow+1,currCol,m,n,memo,matrix);
        
        memo.put(currentKey, Math.min(right, Math.min(diagonal,bottom)));
        return Math.min(right, Math.min(diagonal,bottom));
    }
}
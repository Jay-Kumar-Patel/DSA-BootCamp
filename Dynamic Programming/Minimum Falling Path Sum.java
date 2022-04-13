class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = 10001;
        HashMap<String,Integer> memo = new HashMap<>();
        for(int currCol=0;currCol<n;currCol++){
            int temp = minPath(m,n,0,currCol,matrix,memo);
            ans = Math.min(ans,temp);
        }
        return ans;
    }
    
    private int minPath(int m, int n, int currRow, int currCol, int[][] matrix, HashMap<String,Integer> memo){
        if(currRow<0 || currRow>=m || currCol<0 || currCol>=n)
            return 10001;
        
        if(currRow == m-1)
          return matrix[currRow][currCol];
        
        String currentKey = currRow + "-" + currCol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int leftBottom = matrix[currRow][currCol] + minPath(m,n,currRow+1,currCol-1,matrix,memo);
        int bottom = matrix[currRow][currCol] + minPath(m,n,currRow+1,currCol,matrix,memo);
        int rightBottom = matrix[currRow][currCol] + minPath(m,n,currRow+1,currCol+1,matrix,memo);
        
        memo.put(currentKey, Math.min(leftBottom,Math.min(bottom,rightBottom)));
        return Math.min(leftBottom, Math.min(bottom,rightBottom));
    }
}
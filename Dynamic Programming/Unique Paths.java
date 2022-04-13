class Solution {
    public int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n, new HashMap<String,Integer>());
    }
    
    private int countPaths(int currRow, int currCol, int m, int n, HashMap<String, Integer> memo){
        
        if(currRow == m-1 && currCol == n-1)
            return 1;
        
        if(currRow >= m || currCol >= n)
            return 0;
        
        String currentKey = currRow + "-" + currCol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int right = countPaths(currRow,currCol+1,m,n,memo);
        int down = countPaths(currRow+1,currCol,m,n,memo);
        
        memo.put(currentKey, right+down);
        return right+down;
    }
}
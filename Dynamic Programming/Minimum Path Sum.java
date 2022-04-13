class Solution {
    public int minPathSum(int[][] grid) {
        return minSumPath(grid,0,0,grid.length,grid[0].length,new HashMap<String,Integer>());
    }
    
    private int minSumPath(int[][] grid, int currrow, int currcol, int m ,int n, HashMap<String,Integer> memo){
        if(currrow == m-1 && currcol == n-1)
            return grid[currrow][currcol];
        if(currrow>= m || currcol>=n)
            return 10001;
        
        String currentKey = currrow+"-"+currcol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int right = grid[currrow][currcol] + minSumPath(grid,currrow+1,currcol,m,n,memo);
        int down = grid[currrow][currcol] + minSumPath(grid,currrow,currcol+1,m,n,memo);
        
        memo.put(currentKey, Math.min(right,down));
        return Math.min(right,down);
    }
}
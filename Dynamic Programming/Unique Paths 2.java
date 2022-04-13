class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return countPaths(0, 0, obstacleGrid ,new HashMap<String,Integer>());
    }
    
    private int countPaths(int currRow, int currCol, int[][] matrix, HashMap<String,Integer> memo){
        
        if(currRow >= matrix.length || currCol >= matrix[0].length || matrix[currRow][currCol] == 1)
            return 0;
        
        if(currRow == matrix.length-1 && currCol == matrix[0].length-1)
            return 1;
        
        String currentKey = currRow + "-" + currCol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int right = countPaths(currRow,currCol+1,matrix,memo);
        int down = countPaths(currRow+1,currCol,matrix,memo);
        
        memo.put(currentKey, right+down);
        return right+down;
    }
}
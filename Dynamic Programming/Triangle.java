class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minCost(triangle, 0, 0, triangle.size(), new HashMap<String,Integer>());
    }
    
    private int minCost(List<List<Integer>> triangle, int i, int j, int size, HashMap<String,Integer> memo){
        
        if(i == size-1)
            return triangle.get(i).get(j);
        
        String currentKey = i + "-" + j;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int bottom = triangle.get(i).get(j) + minCost(triangle,i+1,j,size,memo);
        int bottomright = triangle.get(i).get(j) + minCost(triangle,i+1,j+1,size,memo);
        
        memo.put(currentKey, Math.min(bottom,bottomright));
        return Math.min(bottom,bottomright);
    }
}
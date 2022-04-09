class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return maxRobSum(nums,0,memo);
    }
    
    private int maxRobSum(int[] nums, int currentHouse, HashMap<Integer, Integer> memo){
        
        if(currentHouse >= nums.length){
            return 0;
        }
        
        int currentKey = currentHouse;
        
        if(memo.containsKey(currentHouse))
            return memo.get(currentHouse);
        
        int rob = nums[currentHouse] + maxRobSum(nums, currentHouse+2, memo);
        int noRob = maxRobSum(nums, currentHouse+1, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return Math.max(rob,noRob);
    }
}
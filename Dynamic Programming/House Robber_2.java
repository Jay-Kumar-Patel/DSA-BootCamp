class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> memo2 = new HashMap<Integer, Integer>();
        if(nums.length == 1)
            return nums[0];
        return Math.max(maxRobSum(nums,0,nums.length-1,memo1), maxRobSum(nums,1,nums.length,memo2));
    }
    
    private int maxRobSum(int[] nums, int startHouse, int endHouse, HashMap<Integer, Integer> memo){
        
        if(startHouse >= endHouse){
            return 0;
        }
        
        int currentKey = startHouse;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int rob = nums[startHouse] + maxRobSum(nums, startHouse+2, endHouse, memo);
        int noRob = maxRobSum(nums, startHouse+1, endHouse, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return Math.max(rob,noRob);
    }
}
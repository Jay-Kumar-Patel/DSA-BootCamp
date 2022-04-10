class Solution {
    public boolean canPartition(int[] nums) {
        
        int targetSum = 0;
        
        for(int num:nums){
            targetSum += num;
        }
        
        if(targetSum%2 != 0){
            return false;
        }
        
        return checkPartition(0,nums,targetSum/2, new HashMap<String, Boolean>());
    }
    
    public boolean checkPartition(int currentIndex, int[] nums, int targetSum, Map<String, Boolean> memo){
        
        if(targetSum == 0){
            return true;
        }
            
        if(currentIndex == nums.length){
            return false;
        }
        
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(targetSum);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        boolean consider = false;
        
        if(nums[currentIndex] <= targetSum){
            consider = checkPartition(currentIndex+1, nums, targetSum-nums[currentIndex], memo);
        }
        
        if(consider){
            memo.put(currentKey, true);
            return true;
        }
        
        boolean notconsider = checkPartition(currentIndex+1, nums, targetSum, memo);
        
        memo.put(currentKey, consider||notconsider);
        return consider||notconsider;
    }
}
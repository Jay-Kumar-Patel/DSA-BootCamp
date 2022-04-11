class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(0,nums,target, new HashMap<String,Integer>());
    }
    
    private int count(int currentIndex, int[] nums, int target, HashMap<String,Integer> memo){
        
        if(currentIndex == nums.length && target == 0)
            return 1;
        
        if(currentIndex == nums.length && target != 0)
            return 0;
        
        String currentKey = Integer.toString(currentIndex)+"-"+Integer.toString(target);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int plusSign = count(currentIndex+1, nums, target-nums[currentIndex], memo);
        int negSign = count(currentIndex+1, nums, target+nums[currentIndex], memo);
        
        memo.put(currentKey, plusSign+negSign);
        return plusSign+negSign;
    }
}
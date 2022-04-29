class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0;i<nums.length;i++){
            
            int complement = target - nums[i];
            
            if(memo.containsKey(complement)){
                ans[0] = memo.get(complement);
                ans[1] = i;
            }
            else{
                memo.put(nums[i], i);
            }    
        }
        
        return ans;
    }
}
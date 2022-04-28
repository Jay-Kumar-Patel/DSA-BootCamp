class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        int ans = 0;
        int prefixSum = 0;
        
        memo.put(prefixSum, 1);
        
        for(int i=0;i<nums.length;i++){
            
            prefixSum += nums[i];
            
            if(memo.containsKey(prefixSum-k)){
                ans += memo.get(prefixSum-k);
            }
            
            if(memo.containsKey(prefixSum))
                memo.put(prefixSum, memo.get(prefixSum)+1);
            
            else{
                memo.put(prefixSum, 1);
            }
        }
        
        return ans;
    }
}
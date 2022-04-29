class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        int ans = 0;
        int prefixSum = 0;
        
        memo.put(prefixSum, 1);
        
        for(int i=0;i<nums.length;i++){
            
            prefixSum += nums[i];
            
            int currRem = ((prefixSum % k) + k) % k;
            
            if(memo.containsKey(currRem)){
                 ans += memo.get(currRem);
                 memo.put(currRem, memo.get(currRem)+1);
            }
            else
                memo.put(currRem, 1);
        }
        
        return ans;
    }
}
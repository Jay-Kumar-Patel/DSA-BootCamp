class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int ans = 0;
        int prefixSum = 0;
        
        memo.put(prefixSum, -1);
        
        for(int i=0;i<n;i++){
            
            prefixSum += a[i];
            
            int currRem = ((prefixSum % k) + k) % k;
            
            if(memo.containsKey(currRem)){
                 ans = Math.max(ans, i - memo.get(currRem));
            }
            else
                memo.put(currRem, i);
        }
        
        return ans;
    }
}
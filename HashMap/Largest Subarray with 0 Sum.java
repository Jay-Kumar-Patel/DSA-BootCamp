class GfG
{
    int maxLen(int arr[], int n)
    {
        int prefixSum = 0;
        int ans = 0;
        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,-1);
        
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            if(memo.containsKey(prefixSum)){
                ans = Math.max(ans, i-memo.get(prefixSum));
            }
            else{
                memo.put(prefixSum,i);
            }
        }
        
        return ans;
    }
}
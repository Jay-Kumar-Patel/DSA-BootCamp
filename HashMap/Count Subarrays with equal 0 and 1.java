class Solution
{
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,1);
        
        int prefixSum = 0;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            
            if(memo.containsKey(prefixSum)){
                ans += memo.get(prefixSum);
                memo.put(prefixSum, 1+memo.get(prefixSum));
            }
            else{
                memo.put(prefixSum, 1);
            }
        }
        
        return ans;
    }
}

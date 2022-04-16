class Solution {
    
    int maxLen(int[] arr, int N)
    {
        for(int i=0;i<N;i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,-1);
        
        int prefixSum = 0;
        int ans = 0;
        for(int i=0;i<N;i++){
            prefixSum += arr[i];
            if(memo.containsKey(prefixSum)){
                ans = Math.max(ans, i - memo.get(prefixSum));
            }
            else{
                memo.put(prefixSum,i);
            }
        }
        
        return ans;
    }
}

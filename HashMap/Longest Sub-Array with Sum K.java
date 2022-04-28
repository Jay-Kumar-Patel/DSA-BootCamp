class Solution{
    
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int ans = 0;
        int prefixSum = 0;
        
        memo.put(prefixSum, -1);
        
        for(int i=0;i<N;i++){
            
            prefixSum += A[i];
            
            if(memo.containsKey(prefixSum-K)){
                ans = Math.max(ans, i - memo.get(prefixSum-K));
            }
            
            if(!memo.containsKey(prefixSum))
                memo.put(prefixSum,i);
        }
        
        return ans;
    }
}
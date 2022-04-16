class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] memo = new int[k];
        
        for(int currNum : arr){
            int currRem = ((currNum % k)+k) % k;
            memo[currRem] += 1; 
        }
        
        for(int i=0;i<=k/2;i++){
            if(i == 0){
                if(memo[i] % 2 != 0){
                    return false;
                }
            }
            else{
                if(memo[i] != memo[k-i])
                    return false;
            }
        }
        return true;
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] memo = new int[coins.length][amount+1];
        
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                memo[i][j] = -1;
            }
        }
        
        int ans =  totalWays(amount,coins,0,memo);
        if(ans == 10001)
            return -1;
        return ans;
    }
    
    private int totalWays(int amount, int[] coins, int currentIndex, int[][] memo){
        
        if(amount == 0)
            return 0;
        
        if(currentIndex >= coins.length)
            return 10001;
        
        if(memo[currentIndex][amount] != -1){
            return memo[currentIndex][amount];
        }
        
        int consider = 10001;
        if(coins[currentIndex] <= amount){
            consider = 1 + totalWays(amount - coins[currentIndex], coins, currentIndex, memo);
        }
        int notconsider = totalWays(amount, coins, currentIndex+1, memo);
        
        memo[currentIndex][amount] = Math.min(consider,notconsider);
        return Math.min(consider,notconsider);
    }
    
}
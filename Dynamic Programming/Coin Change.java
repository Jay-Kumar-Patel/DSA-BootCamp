//Java Code
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





//C++ Code
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        vector<vector<int>> memo(coins.size(), vector<int>(amount+1,-1));
        int ans = totalWays(0,amount,coins,memo);
        
        if(ans == 100001)
            return -1;
        else
            return ans;
    }
    
    int totalWays(int currIndex, int amount, vector<int>& coins,  vector<vector<int>>& memo){
        
        if(amount == 0)
            return 0;
        
        if(currIndex >= coins.size())
            return 100001;
        
        if(memo[currIndex][amount] != -1)
            return memo[currIndex][amount];
        
        int consider = 100001;
        if(amount >= coins[currIndex])
            consider = 1 + totalWays(currIndex,amount-coins[currIndex],coins,memo);
        
        int notConsider =  totalWays(currIndex+1,amount,coins,memo);
        
        memo[currIndex][amount] = min(consider, notConsider);
        return min(consider, notConsider);
    }
    
};

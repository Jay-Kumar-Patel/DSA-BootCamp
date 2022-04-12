class Solution {
    public int maxProfit(int[] prices) {
        
        int[][][] memo = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    memo[i][j][k] = -1;
                }
            }
        }
        
        return maxProfitGain(prices, 0, 1, 2, memo);
    }
    
    private int maxProfitGain(int[] prices, int currentDay, int canBuy, int transCount, int[][][] memo){
        
        if(currentDay >= prices.length || transCount == 0)
            return 0;
        
        if(memo[currentDay][canBuy][transCount] != -1){
            return memo[currentDay][canBuy][transCount];
        }
        
        if(canBuy == 1){
            int idle = maxProfitGain(prices,currentDay+1,canBuy,transCount,memo);
            int buy = -prices[currentDay] + maxProfitGain(prices,currentDay+1,0,transCount,memo);
            memo[currentDay][canBuy][transCount] = Math.max(idle,buy);
            return Math.max(idle,buy);
        }
        else{
            int idle = maxProfitGain(prices,currentDay+1,canBuy,transCount,memo);
            int sell = prices[currentDay] + maxProfitGain(prices,currentDay+1,1,transCount-1,memo);
            memo[currentDay][canBuy][transCount] = Math.max(idle,sell);
            return Math.max(idle,sell);
        }
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitGain(prices, 0, 1, new HashMap<String,Integer>());
    }
    
    private int maxProfitGain(int[] prices, int currentDay, int canBuy, HashMap<String,Integer> memo){
        
        if(currentDay >= prices.length)
            return 0;
        
        String currentKey = currentDay+"-"+canBuy;
            
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(canBuy == 1){
            int idle = maxProfitGain(prices,currentDay+1,canBuy,memo);
            int buy = -prices[currentDay] + maxProfitGain(prices,currentDay+1,0,memo);
            memo.put(currentKey, Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else{
            int idle = maxProfitGain(prices,currentDay+1,canBuy,memo);
            int sell = prices[currentDay] + maxProfitGain(prices,currentDay+1,1,memo);
            memo.put(currentKey, Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}
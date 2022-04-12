class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maxProfitGain(prices, 0, 1, fee, new HashMap<String,Integer>());
    }
    
    private int maxProfitGain(int[] prices, int currentDay, int canBuy, int fee, HashMap<String,Integer> memo){
        
        if(currentDay >= prices.length)
            return 0;
        
        String currentKey = currentDay+"-"+canBuy;
            
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(canBuy == 1){
            int idle = maxProfitGain(prices,currentDay+1,canBuy,fee,memo);
            int buy = -prices[currentDay] + maxProfitGain(prices,currentDay+1,0,fee,memo);
            memo.put(currentKey, Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else{
            int idle = maxProfitGain(prices,currentDay+1,canBuy,fee,memo);
            int sell = -fee + prices[currentDay] + maxProfitGain(prices,currentDay+1,1,fee,memo);
            memo.put(currentKey, Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}
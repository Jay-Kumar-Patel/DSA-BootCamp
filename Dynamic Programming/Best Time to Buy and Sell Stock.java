class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitGain(prices, 0, 1, 1, new HashMap<String,Integer>());
    }
    
    private int maxProfitGain(int[] prices, int currentDay, int canBuy, int transCount, HashMap<String,Integer> memo){
        
        if(currentDay >= prices.length || transCount == 0)
            return 0;
        
        String currentKey = currentDay+"-"+canBuy+"-"+transCount;
            
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(canBuy == 1){
            int idle = maxProfitGain(prices,currentDay+1,canBuy,transCount,memo);
            int buy = -prices[currentDay] + maxProfitGain(prices,currentDay+1,0,transCount,memo);
            memo.put(currentKey, Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else{
            int idle = maxProfitGain(prices,currentDay+1,canBuy,transCount,memo);
            int sell = prices[currentDay] + maxProfitGain(prices,currentDay+1,1,transCount-1,memo);
            memo.put(currentKey, Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}
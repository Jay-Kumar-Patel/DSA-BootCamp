class Solution {
    public int change(int amount, int[] coins) {
        return totalWays(amount,coins,0,new HashMap<String,Integer>());
    }
    
    private int totalWays(int amount, int[] coins, int currentIndex, HashMap<String,Integer> memo){
        
        if(amount == 0)
            return 1;
        
        if(currentIndex >= coins.length)
            return 0;
        
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amount);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int consider = 0;
        if(coins[currentIndex] <= amount){
            consider = totalWays(amount - coins[currentIndex], coins, currentIndex, memo);
        }
        int notconsider = totalWays(amount, coins, currentIndex+1, memo);
        
        memo.put(currentKey,consider+notconsider);
        return consider+notconsider;
    }
}
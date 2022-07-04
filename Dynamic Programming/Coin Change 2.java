//Java Code
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





//C++ Code
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        unordered_map<string,int> memo;
        return totalWays(0,amount,coins,memo);
    }
    
    int totalWays(int currIndex, int amount, vector<int>& coins, unordered_map<string,int>& memo){
        
        if(amount == 0)
            return 1;
        
        if(currIndex >= coins.size())
            return 0;
        
        string currKey = to_string(currIndex) + "-" + to_string(amount);
        
        if(memo.find(currKey) != memo.end())
            return memo[currKey];
        
        int consider = 0;
        if(amount >= coins[currIndex])
            consider = totalWays(currIndex,amount-coins[currIndex],coins,memo);
        
        int notConsider =  totalWays(currIndex+1,amount,coins,memo);
        
        memo[currKey] = consider+notConsider;
        return consider+notConsider;
    }
};

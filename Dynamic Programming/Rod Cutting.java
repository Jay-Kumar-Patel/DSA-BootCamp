//Java Code
class Solution{
    public int cutRod(int price[], int n) {
        int[][] memo = new int[price.length][n+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                memo[i][j] = -1;
            }
        }
        
        return maxProfit(0,price,n,memo);
    }
    
    private int maxProfit(int currentIndex, int[] prices, int lengthRod, int[][] memo){
        
        if(currentIndex >= prices.length){
            return 0;
        }
        
        if(lengthRod == 0){
            return 0;
        }
        
        if(memo[currentIndex][lengthRod] != -1){
            return memo[currentIndex][lengthRod];
        }
        
        int consider = 0;
        if(lengthRod >= currentIndex+1){
            consider = prices[currentIndex] + maxProfit(currentIndex,prices,lengthRod-(currentIndex+1),memo);
        }
        
        int notconsider = maxProfit(currentIndex+1,prices,lengthRod,memo);
        memo[currentIndex][lengthRod] = Math.max(consider,notconsider);
        return Math.max(consider,notconsider);
    }
}





//C++ Code
class Solution{
  public:
    int cutRod(int price[], int n) {
        
        unordered_map<string,int> memo;
        return maxProfit(0,price,memo,n,n);
    }
    
    int maxProfit(int currIndex, int prices[], unordered_map<string,int>& memo, int currLength, int n){
        
        if(currIndex >= n)
            return 0;
        
        if(currLength == 0)
            return 0;
        
        string currKey = to_string(currIndex) + "-" + to_string(currLength);
        
        if(memo.find(currKey) != memo.end())
            return memo[currKey];
        
        int consider = 0;
        if(currLength >= currIndex+1)
            consider = prices[currIndex] + maxProfit(currIndex,prices,memo,currLength-(currIndex+1),n);
        
        int notConsider =  maxProfit(currIndex+1,prices,memo,currLength,n);
        
        memo[currKey] = max(consider, notConsider);
        return max(consider, notConsider);
    }
};

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
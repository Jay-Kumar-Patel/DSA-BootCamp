class Solution{
    public int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] memo = new int[N][W+1];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<W+1;j++){
                memo[i][j] = -1;
            }
        }
        
        return maxProfit(wt,val,0,W,N,memo);
    }
    
    private int maxProfit(int[] weights, int[] profits, int currentIndex, int totalweight, int N, int[][] memo){
        
        if(currentIndex >= N){
            return 0;
        }
        
        if(memo[currentIndex][totalweight] != -1){
            return memo[currentIndex][totalweight];
        }
        
        int consider = 0;
        
        if(weights[currentIndex] <= totalweight){
            consider = profits[currentIndex] + maxProfit(weights,profits,currentIndex,totalweight-weights[currentIndex],N,memo);
        }
        
        int notconsider = maxProfit(weights,profits,currentIndex+1,totalweight,N,memo);
        
        memo[currentIndex][totalweight] = Math.max(consider,notconsider);
        return Math.max(consider,notconsider);
    }
}
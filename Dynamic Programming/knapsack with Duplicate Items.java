//Java Code
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





//C++ Code
class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        vector<vector<int>> memo(N, vector<int>(W+1,-1));
        return maxProfit(0,W,val,wt,memo,N);
    }
    
    int maxProfit(int currIndex, int capacity, int val[], int wt[], vector<vector<int>>& memo, int N){
        
        if(currIndex == N)
            return 0;
    
        if(memo[currIndex][capacity] != -1)
            return memo[currIndex][capacity];
            
        int consider = 0;
        if(capacity >= wt[currIndex]){
            consider = val[currIndex] + maxProfit(currIndex,capacity-wt[currIndex],val,wt,memo,N);
        }
        
        int notConsider = maxProfit(currIndex+1,capacity,val,wt,memo,N);
        
        memo[currIndex][capacity] = max(consider, notConsider);
        return max(consider, notConsider);
    }
};

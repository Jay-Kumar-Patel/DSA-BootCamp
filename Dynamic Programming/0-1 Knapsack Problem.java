class Solution 
{ 
    public int knapSack(int W, int wt[], int val[], int n) 
    { 
        return maxProfit(wt, val, 0, W, n, new HashMap<String,Integer>());
    } 
    
    private int maxProfit(int[] weights, int[] profits, int currentIndex, int totalweight, int N, HashMap<String, Integer> memo){
        
        if(currentIndex == N){
            return 0;
        }
        
        String currentKey = Integer.toString(currentIndex)+"-"+Integer.toString(totalweight);
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int consider = 0;
        
        if(weights[currentIndex] <= totalweight){
            consider = profits[currentIndex] + maxProfit(weights,profits,currentIndex+1,totalweight-weights[currentIndex],N,memo);
        }
        
        int notconsider = maxProfit(weights,profits,currentIndex+1,totalweight,N,memo);
        
        memo.put(currentKey, Math.max(consider,notconsider));
        return Math.max(consider,notconsider);
    } 
}

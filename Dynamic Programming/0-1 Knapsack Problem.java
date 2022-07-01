//Java Code
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





//C++ Code
class Solution
{
    public:
    int knapSack(int W, int wt[], int val[], int n) 
    { 
        unordered_map<string,int> memo;
        return maxProfit(0,W,wt,val,n,memo);
    }
    
    int maxProfit(int currIndex, int W, int wt[], int val[], int n, unordered_map<string,int>& memo){
        
        if(currIndex == n)
            return 0;
            
        string currentKey  = to_string(currIndex) + "-" + to_string(W);
        
        if(memo.find(currentKey) != memo.end())
            return memo[currentKey];
        
        int consider = 0;
        if(W >= wt[currIndex]){
            consider = val[currIndex] + maxProfit(currIndex+1, W-wt[currIndex], wt, val, n, memo);
        }
        
        int notConsider = maxProfit(currIndex+1, W, wt, val, n, memo);
        
        memo[currentKey] = max(consider, notConsider);
        return max(consider, notConsider);
        
    }
};

//Java Code
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return Math.min(minCost(cost, 0, memo) , memo.get(1));
    }
    
    private int minCost(int[] cost, int currentIndex, HashMap<Integer, Integer> memo){
        
        if(currentIndex == cost.length){
            return 0;
        }
        if(currentIndex > cost.length){
            return 1001;
        }
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentIndex)){
            return memo.get(currentIndex);    
        }
        
        int oneJump = cost[currentIndex] + minCost(cost, currentIndex+1, memo);
        int twoJump = cost[currentIndex] + minCost(cost, currentIndex+2, memo);
        
        memo.put(currentKey, Math.min(oneJump,twoJump));
        return Math.min(oneJump,twoJump);
    }
}





//C++ Code
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        unordered_map<int,int> memo;
        return min(minCostPath(0,cost,memo),memo[1]);
    }
    
    int minCostPath(int currInd, vector<int>& cost, unordered_map<int,int>& memo){
        
        if(currInd == cost.size())
            return 0;
        if(currInd > cost.size())
            return 100001;
        
        if(memo.find(currInd) != memo.end())
            return memo[currInd];
        
        int oneStep = cost[currInd] + minCostPath(currInd+1,cost,memo);
        int twoStep = cost[currInd] + minCostPath(currInd+2,cost,memo);
        
        memo[currInd] = min(oneStep,twoStep);
        
        return min(oneStep,twoStep);
    }
};

//Java Code
class Solution {
    public int climbStairs(int n) {
        return countStairs(0, n, new HashMap<Integer, Integer>());
    }
    
    private int countStairs(int currentStair, int target, HashMap<Integer, Integer> memo){
        
        if(currentStair == target){
            return 1;
        }
        if(currentStair > target){
            return 0;
        }
        
        int currentKey = currentStair;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int jumpone = countStairs(currentStair+1, target, memo);
        int jumptwo = countStairs(currentStair+2, target, memo);
        
        memo.put(currentKey, jumpone+jumptwo);
        return jumpone+jumptwo;
    }
}





//C++ Code
class Solution {
public:
    int climbStairs(int n) {
        unordered_map<int,int> memo;
        return totalways(0,n,memo);
    }
    
    int totalways(int currStair, int n, unordered_map<int,int>& memo){
        
        if(currStair == n)
            return 1;
        if(currStair > n)
            return 0;
        
        if(memo.find(currStair) != memo.end())
            return memo[currStair];
        
        int oneStep = totalways(currStair+1,n,memo);
        int twoStep = totalways(currStair+2,n,memo);
        
        memo[currStair] = oneStep + twoStep;
        
        return oneStep+twoStep;
    }
};

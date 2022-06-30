//Java Code
class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return maxRobSum(nums,0,memo);
    }
    
    private int maxRobSum(int[] nums, int currentHouse, HashMap<Integer, Integer> memo){
        
        if(currentHouse >= nums.length){
            return 0;
        }
        
        int currentKey = currentHouse;
        
        if(memo.containsKey(currentHouse))
            return memo.get(currentHouse);
        
        int rob = nums[currentHouse] + maxRobSum(nums, currentHouse+2, memo);
        int noRob = maxRobSum(nums, currentHouse+1, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return Math.max(rob,noRob);
    }
}





//C++ Code
class Solution {
public:
    int rob(vector<int>& nums) {
        unordered_map<int,int> memo;
        return maxRob(0,nums,memo);
    }
    
    int maxRob(int currHouse, vector<int>& nums, unordered_map<int,int>& memo){
        
        if(currHouse >= nums.size())
            return 0;
        
        if(memo.find(currHouse) != memo.end())
            return memo[currHouse];
        
        int consider = nums[currHouse] + maxRob(currHouse+2, nums, memo);
        int notConsider = maxRob(currHouse+1, nums, memo);
        
        memo[currHouse] = max(consider, notConsider);
        
        return max(consider, notConsider);
    }
};

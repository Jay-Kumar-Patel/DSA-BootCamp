//Java Code
class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> memo2 = new HashMap<Integer, Integer>();
        if(nums.length == 1)
            return nums[0];
        return Math.max(maxRobSum(nums,0,nums.length-1,memo1), maxRobSum(nums,1,nums.length,memo2));
    }
    
    private int maxRobSum(int[] nums, int startHouse, int endHouse, HashMap<Integer, Integer> memo){
        
        if(startHouse >= endHouse){
            return 0;
        }
        
        int currentKey = startHouse;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int rob = nums[startHouse] + maxRobSum(nums, startHouse+2, endHouse, memo);
        int noRob = maxRobSum(nums, startHouse+1, endHouse, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return Math.max(rob,noRob);
    }
}





//C++ Code
class Solution {
public:
    int rob(vector<int>& nums) {
        unordered_map<int,int> memo0;
        unordered_map<int,int> memo1;
        
        if(nums.size() == 1)
            return nums[0];
        
        return max(maxRob(0,nums,memo0,nums.size()-1),maxRob(1,nums,memo1,nums.size()));
    }
    
    int maxRob(int currHouse, vector<int>& nums, unordered_map<int,int>& memo, int endHouse){
        
        if(currHouse >= endHouse)
            return 0;
        
        if(memo.find(currHouse) != memo.end())
            return memo[currHouse];
        
        int consider = nums[currHouse] + maxRob(currHouse+2, nums, memo, endHouse);
        int notConsider = maxRob(currHouse+1, nums, memo, endHouse);
        
        memo[currHouse] = max(consider, notConsider);
        
        return max(consider, notConsider);
    }
};

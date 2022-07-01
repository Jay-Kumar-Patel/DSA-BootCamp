//Java Code
class Solution {
    public boolean canPartition(int[] nums) {
        
        int targetSum = 0;
        
        for(int num:nums){
            targetSum += num;
        }
        
        if(targetSum%2 != 0){
            return false;
        }
        
        return checkPartition(0,nums,targetSum/2, new HashMap<String, Boolean>());
    }
    
    public boolean checkPartition(int currentIndex, int[] nums, int targetSum, Map<String, Boolean> memo){
        
        if(targetSum == 0){
            return true;
        }
            
        if(currentIndex == nums.length){
            return false;
        }
        
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(targetSum);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        boolean consider = false;
        
        if(nums[currentIndex] <= targetSum){
            consider = checkPartition(currentIndex+1, nums, targetSum-nums[currentIndex], memo);
        }
        
        if(consider){
            memo.put(currentKey, true);
            return true;
        }
        
        boolean notconsider = checkPartition(currentIndex+1, nums, targetSum, memo);
        
        memo.put(currentKey, consider||notconsider);
        return consider||notconsider;
    }
}





//C++ Code
class Solution {
public:
    bool canPartition(vector<int>& nums) {
        
        int sum = 0;
        for(int i=0;i<nums.size();i++){
            sum += nums[i];
        }
        
        if(sum%2 != 0)
            return false;
        
        unordered_map<string, bool> memo;
        return checkPartition(0,nums,memo,sum/2);
    }
    
    bool checkPartition(int currIndex, vector<int>& nums, unordered_map<string,bool>& memo, int sum){
        
        if(currIndex >= nums.size())
            return false;
            
        if(sum == 0)
            return true;
        
        string currentKey = to_string(currIndex) + "-" + to_string(sum);
        
        if(memo.find(currentKey) != memo.end())
            return memo[currentKey];
        
        bool consider = false;
        if(sum >= nums[currIndex])
            consider = checkPartition(currIndex+1, nums, memo, sum-nums[currIndex]);
        
        if(consider == true){
            memo[currentKey] = true;
            return true;
        }
        
        bool notConsider = checkPartition(currIndex+1, nums, memo, sum);
        
        memo[currentKey] = (consider || notConsider);
        return (consider || notConsider);
    }
};

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
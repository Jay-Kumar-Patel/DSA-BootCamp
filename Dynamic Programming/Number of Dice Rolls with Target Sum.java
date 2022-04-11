class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return totalways(n,k,target, new HashMap<String,Integer>());
    }
    
    private int totalways(int dice, int faces, int targetSum, HashMap<String,Integer> memo){
        
        if(dice==0 && targetSum==0)
            return 1;
        
        if(dice==0 || targetSum<=0)
            return 0;
        
        String currentKey = dice + "-" + targetSum;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ways=0;
        int MOD = 1000000007;
        
        for(int f=1;f<=faces;f++){
            int tempAns = totalways(dice-1,faces,targetSum-f,memo) % MOD;
            ways = ways % MOD;
            ways = (tempAns+ways) % MOD;
        }
        
        memo.put(currentKey,ways);
        return ways;
    }
}
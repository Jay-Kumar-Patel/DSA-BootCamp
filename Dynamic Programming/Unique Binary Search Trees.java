class Solution {
    public int numTrees(int n) {
        return totalwaysUniqueBST(n, new HashMap<Integer,Integer>());
    }
    
    private int totalwaysUniqueBST(int n,HashMap<Integer,Integer> memo){
        if(n==0 || n==1){
            return 1;
        }
        
        if(memo.containsKey(n))
            return memo.get(n);
        
        int ways = 0;
        for(int i=0;i<n;i++){
            ways += totalwaysUniqueBST(i,memo) * totalwaysUniqueBST(n-i-1,memo);
        }
        
        memo.put(n,ways);
        return ways;
    }
}
class Geeks {
    public long count(int n) {
       int[] score = {3,5,10};
       return totalWays(score, 0, n, new HashMap<String,Integer>());
    }
    
    public int totalWays(int[] score, int currentIndex, int n, HashMap<String,Integer> memo){
        if(n==0)
            return 1;
        if(currentIndex >= score.length)
            return 0; 
        
        String currentKey = currentIndex + "-" + n;
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int consider = 0; 
        if(score[currentIndex] <= n){
            consider = totalWays(score, currentIndex, n - score[currentIndex], memo);
        }
        
        int notConsider = totalWays(score, currentIndex + 1, n, memo);
        
        memo.put(currentKey, consider + notConsider);
        
        return memo.get(currentKey); 
    }
}
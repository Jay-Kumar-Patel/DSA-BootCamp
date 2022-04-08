class Solution {
    public int fib(int n) {
        return fibnum(n, new HashMap<Integer, Integer>());
    }
    
    private int fibnum(int n, HashMap<Integer, Integer> memo){
        
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int a = fibnum(n-1,memo);
        int b = fibnum(n-2,memo);
        
        memo.put(currentKey, a+b);
        return a+b;
    }
}
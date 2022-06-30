//Java Code
class Solution {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return nthtri(n, memo);
    }
    
    private int nthtri(int n, HashMap<Integer, Integer> memo){
        
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
            
        int a = nthtri(n-1, memo);
        int b = nthtri(n-2, memo);
        int c = nthtri(n-3, memo);
        
        memo.put(currentKey, a+b+c);
        return a+b+c;
    }
}





//C++ Code
class Solution {
public:
    int tribonacci(int n) {
        unordered_map<int,int> memo;
        return tri(n,memo);
    }
    
    int tri(int n, unordered_map<int,int>& memo){
        
        if(n==0 || n==1)
            return n;
        if(n == 2)
            return 1;
        
        if(memo.find(n) != memo.end())
            return memo[n];
        
        int a = tri(n-1,memo);
        int b = tri(n-2,memo);
        int c = tri(n-3,memo);
        
        memo[n] = a+b+c;
        return a+b+c;
    }
};

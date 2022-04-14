class Solution {
    public int minDistance(String s1, String s2) {
        return minOperation(s1, s2, 0, 0, s1.length(), s2.length(), new HashMap<String,Integer>());
    }
    
    private int minOperation(String s1, String s2, int i, int j, int m, int n, HashMap<String,Integer> memo){
        
        if(i >= m)
            return n-j;
        
        if(j >= n)
            return m-i;
            
        String currentKey = i + "-" + j;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans = 100001;

        if(s1.charAt(i) == s2.charAt(j))
            ans = minOperation(s1,s2,i+1,j+1,m,n,memo);
        else{
            int insert = 1 + minOperation(s1,s2,i,j+1,m,n,memo);
            int delete = 1 + minOperation(s1,s2,i+1,j,m,n,memo);
            int update = 1 + minOperation(s1,s2,i+1,j+1,m,n,memo);
            
            ans = Math.min(insert, Math.min(delete,update));
        }
        
        memo.put(currentKey, ans);
        return ans;
    }
}
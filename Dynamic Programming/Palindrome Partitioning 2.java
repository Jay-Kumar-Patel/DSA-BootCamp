class Solution {
    public int minCut(String s) {
        return minCutPalindrome(s,0,s.length()-1,new HashMap<Integer,Integer>());
    }
    
    private int minCutPalindrome(String s, int start, int end, HashMap<Integer,Integer> memo){
        
        if(isPalindrome(s,start,end))
            return 0;
        
        int currentKey = start;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans = 1000001;
        for(int i=start; i<end; i++){
            if(isPalindrome(s,start,i)){
                int tempAns = 1 + minCutPalindrome(s,i+1,end,memo);
                ans = Math.min(ans,tempAns);   
            }
        }
        
        memo.put(currentKey, ans);
        return ans;
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        long ans = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        
        String expression = (z1-z0) + "-" + (z2-z1);
        memo.put(expression, 1);
        
        for(int i=0;i<str.length();i++){
            
            if(str.charAt(i) == '0')
                z0 += 1;
            else if(str.charAt(i) == '1')
                z1 += 1;
            else
                z2 += 1;
            
            expression = (z1-z0) + "-" + (z2-z1);
            
            if(memo.containsKey(expression)){
                ans += memo.get(expression);
                memo.put(expression, memo.get(expression)+1);
            }
            else{
                memo.put(expression, 1);
            }
        }
        
        return ans;
    }
} 
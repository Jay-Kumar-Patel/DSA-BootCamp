class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character,Integer> memo = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            
            Character currChar = s.charAt(i);
            
            if(memo.containsKey(currChar))
                memo.put(currChar, memo.get(currChar)+1);
            
            else{
                memo.put(currChar, 1);
            }
        }
        
        for(int i=0;i<t.length();i++){
            
            Character currChar = t.charAt(i);
            
            if(memo.containsKey(currChar)){
                memo.put(currChar, memo.get(currChar)-1);
                
                if(memo.get(currChar) == 0)
                    memo.remove(currChar);
            }
            else{
                memo.put(currChar, 1);
            }
        }
        
        return memo.isEmpty();
    }
}
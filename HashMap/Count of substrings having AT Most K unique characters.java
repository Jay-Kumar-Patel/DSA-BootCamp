public static int solution(String str, int k) {
    int ans = 0;
    HashMap<Character,Integer> memo = new HashMap<>();
    int release = 0;
    int distinct = 0;
    
    for(int acquire=0; acquire<str.length(); acquire++){
        Character currChar = str.charAt(acquire);
        
        if(memo.containsKey(currChar)){
            memo.put(currChar, memo.get(currChar)+1);
        }
        else{
            memo.put(currChar, 1);
            distinct += 1;
        }
        
        while(release<=acquire && distinct>k){
            Character discard = str.charAt(release);
            release += 1;
            
            memo.put(discard, memo.get(discard)-1);
            if(memo.get(discard) == 0){
                memo.remove(discard);
                distinct -= 1;
            }
        }
        
        ans += acquire - release + 1;
    }
    
    return ans;
}
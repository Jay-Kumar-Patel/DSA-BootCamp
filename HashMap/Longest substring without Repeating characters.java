class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
		HashMap<Character,Integer> memo = new HashMap<>();
		int release = 0;

		for(int acquire=0; acquire<s.length(); acquire++){
			Character currChar = s.charAt(acquire);

			while(release<acquire && memo.containsKey(currChar)){
				Character discard = s.charAt(release);
				memo.remove(discard);
				release += 1;
			}

			memo.put(currChar, 1);
			ans = Math.max(ans, acquire - release + 1);
		}
		
		return ans;
    }
}
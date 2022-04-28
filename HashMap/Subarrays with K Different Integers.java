class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArrays(nums,k) - countSubArrays(nums,k-1);
    }
    
    //Atmost k distinct integers Code
    private int countSubArrays(int[] nums, int k){
        int ans = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        int release = 0;
        int distinct = 0;

        for (int acquire = 0; acquire < nums.length; acquire++) {
          int currInt = nums[acquire];

          if (memo.containsKey(currInt)) {
            memo.put(currInt, memo.get(currInt) + 1);
          }
          else {
            memo.put(currInt, 1);
            distinct += 1;
          }

          while (release <= acquire && distinct > k) {
            int discard = nums[release];
            release += 1;

            memo.put(discard, memo.get(discard) - 1);
            if (memo.get(discard) == 0) {
              memo.remove(discard);
              distinct -= 1;
            }
          }

          ans += acquire - release + 1;
        }

        return ans;
    }
}
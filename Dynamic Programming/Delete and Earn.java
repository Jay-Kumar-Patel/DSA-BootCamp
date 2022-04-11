class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        for(int i: nums){
            max = Math.max(max,i);
        }
        
        int freq[] = new int[max+1];
        
        for(int i: nums){
            freq[i]++; 
        }
        
        return maxEarn(0,freq, new HashMap<Integer,Integer>());
    }
    
    private int maxEarn(int currentIndex, int[] freq, HashMap<Integer, Integer> memo){
        if(currentIndex >= freq.length)
            return 0;
        
        int currentKey = currentIndex;
            
        if(memo.containsKey(currentIndex))
            return memo.get(currentIndex);
        
        int consider = currentIndex*freq[currentIndex] + maxEarn(currentIndex+2, freq, memo);
        int notConsider = maxEarn(currentIndex+1, freq, memo);
        
        memo.put(currentKey, Math.max(consider,notConsider));
        
        return Math.max(consider,notConsider);
    }
}
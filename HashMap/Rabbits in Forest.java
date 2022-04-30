class Solution {
    public int numRabbits(int[] answers) {
        
        double ans = 0;
        HashMap<Integer,Integer> memo = new HashMap<>();
        
        for(int i : answers){
            if(memo.containsKey(i))
                memo.put(i, memo.get(i)+1);
            else{
                memo.put(i, 1);
            }
        }
        
        for(Integer currKey : memo.keySet()){
            double groupSize = currKey+1;
            double numsGroup = Math.ceil(memo.get(currKey) / groupSize);
            ans += numsGroup * groupSize;
        }
        
        return (int)ans;
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> memo = new HashMap<>();
        
        for(int currNum : nums1){
            if(!memo.containsKey(currNum))
                memo.put(currNum,true);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int currNum : nums2){
            if(memo.containsKey(currNum))
                ans.add(currNum);
                memo.remove(currNum);
        }
        
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        
        return result;
    }
}
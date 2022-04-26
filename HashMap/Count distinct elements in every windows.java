class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> memo = new HashMap<>();
        int distinct = 0;
        
        for(int i=0;i<k;i++){
            int currVal = A[i];
            if(memo.containsKey(currVal)){
                memo.put(currVal, memo.get(currVal)+1);
            }
            else{
                memo.put(currVal,1);
                distinct += 1;
            }
        }
        
        ans.add(distinct);
        int release = 0;
        
        for(int acquire=k; acquire<n; acquire++){
            int discard = A[release];
            memo.put(discard, memo.get(discard)-1);
            release += 1;
            
            if(memo.get(discard) == 0){
                memo.remove(discard);
                distinct -= 1;
            }
            
            int currVal = A[acquire];
            if(memo.containsKey(currVal)){
                memo.put(currVal, memo.get(currVal)+1);
            }
            else{
                memo.put(currVal,1);
                distinct += 1;
            }
            
            ans.add(distinct);
        }
        
        return ans;
    }
}
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();
        
        for(int i=0;i<size;i++){
            
            if(memo.containsKey(n + arr[i]) || memo.containsKey(arr[i] - n)){
                return true;
            }
            else{
                memo.put(arr[i], 1);
            }    
        }
        
        return false;
    }
}
class Solution
{
    public BigInteger findCatalan(int n)
    {
        return catalanNo(n, new HashMap<Integer,BigInteger>());
    }
    
    private BigInteger catalanNo(int n, HashMap<Integer,BigInteger> memo){
        if(n==0 || n==1)
            return BigInteger.valueOf(1);
        
        if(memo.containsKey(n))
            return memo.get(n);
            
        BigInteger ans = BigInteger.valueOf(0);
        for(int i=0;i<n;i++){
            ans = ans.add(catalanNo(i,memo).multiply(catalanNo(n-i-1,memo)));
        }
        
        memo.put(n,ans);
        return ans;
    }
}
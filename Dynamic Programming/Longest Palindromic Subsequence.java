class Solution {
    public int longestPalindromeSubseq(String s) {
        
        String reverse_s = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = reverse_s.length();
        
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = -1;
            }
        }
        
        return LPS(s, reverse_s, 0, 0, m, n, memo);
    }
    
    private int LPS(String s1, String s2, int i, int j, int m, int n, int[][] memo){
        
        if(i>=m || j>=n)
            return 0;
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        int ans = 0;
        
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + LPS(s1,s2,i+1,j+1,m,n,memo);
        }
        else{
            int a = LPS(s1,s2,i+1,j,m,n,memo);
            int b = LPS(s1,s2,i,j+1,m,n,memo);
            ans = Math.max(a,b);
        }
        
        memo[i][j] = ans;
        return ans;
    }
}
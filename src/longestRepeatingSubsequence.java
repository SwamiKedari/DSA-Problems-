public class longestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        // this is the dynamic programming based solution with the intuition that if the indexes of the strings are same , then it should not be counted in the length as has the index same
        // the question is to find the longest repeating subsequence in the string
        // we can use the longest common subsequence answer with the condition that the indexes of both n and m can not be equal if both the characters are equal
        int n=str.length();
        int[][] dp=new int[n][n];
        //return getLong(str,n-1,n-1,dp);
        // recursion + memoization solution was not satisfying the time complexity
        dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str.charAt(i-1)==str.charAt(j-1) && i!=j){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public int getLong(String s,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(s.charAt(n)==s.charAt(m) && n!=m){
            dp[n][m]=1+getLong(s,n-1,m-1,dp);
        }
        else{
            dp[n][m]=Math.max(getLong(s,n-1,m,dp),getLong(s,n,m-1,dp));

        }
        return dp[n][m];
    }
}

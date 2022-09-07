public class kPalindrome {
    // this is a dp based problem
    // we need to find whether it is possible to get a palindrome by deleting at most k characters
    boolean is_k_palin(String str, int k)
    {
        // Your code here
        // this problem is a simple problem , we have to find the longest palindromic subsequence length and then we have to check whether the len-lcs is less than equal to the k
        StringBuilder a=new StringBuilder();
        int n=str.length();
        for(int i=n-1;i>-1;i--){
            a.append(str.charAt(i));
        }
        String s=String.valueOf(a);
        int[][] dp=new int[n][n];

        int h=getLong(str,s,n-1,n-1,dp);

        return (n-h)<=k;


    }

    int getLong(String s1,String s2,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(s1.charAt(n)==s2.charAt(m)){
            dp[n][m]=1+getLong(s1,s2,n-1,m-1,dp);
            return dp[n][m];
        }
        else{
            int t=getLong(s1,s2,n-1,m,dp);
            int k=getLong(s1,s2,n,m-1,dp);
            dp[n][m]=Math.max(t,k);
            return dp[n][m];
        }
    }
}

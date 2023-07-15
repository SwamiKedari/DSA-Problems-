package tricky;

public class palindromicStrings {
    public int isPossiblePalindrome(String s,int k)
    {
        // Your code goes here
        // the answer will be true depending on the length of the longest palindromic subsequence
        // the no of characters to be inserted will be equal to the n-lps
        // thus we find the length of the lps and then check the answer on the basis of this values

        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>-1;i--){
            sb.append(s.charAt(i));
        }
        String s1=sb.toString();
        int[][] dp=new int[n+1][n+1];
        int val=getans(s,s1,n-1,n-1,dp);

        if(n-val>k){
            return 0;
        }
        return 1;
    }

    public int getans(String s,String s1,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(s.charAt(i)==s1.charAt(j)){
            return dp[i][j]=getans(s,s1,i-1,j-1,dp)+1;
        }
        else{
            return dp[i][j]=Math.max(getans(s,s1,i-1,j,dp),getans(s,s1,i,j-1,dp));
        }
    }
}

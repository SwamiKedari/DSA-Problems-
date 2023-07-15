package tricky;

public class stringSubsequence  {
    // we have to find the total ways to find the no of subsequence which are equal to the string s2 
    int countWays(String s1, String s2) {
        // code here
        int n=s1.length(), m=s2.length();
        int[][] dp=new int[n+1][m+1];
        boolean[][] vis=new boolean[n+1][m+1];
        return getans(s1,s2,n-1,m-1,vis,dp);
    }

    int getans(String s1,String s2,int i,int j,boolean[][] vis,int[][] dp){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(vis[i][j]){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=getans(s1,s2,i-1,j-1,vis,dp);
        }
        ans+=getans(s1,s2,i-1,j,vis,dp);
        vis[i][j]=true;
        return dp[i][j]=ans;

    }
}

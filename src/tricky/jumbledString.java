package tricky;

public class jumbledString {
    public int mod=(int)1e9+7;
    // we will use dp to solve this type of problems
    // logic for recursion: when both the characters are equal, either move both the indexes or just move s string index
    // when both are not equal, just move second string index
    // we will optimize the recursion using dynamicprogramming and also using the vis boolean array to get the answer

    public int TotalWays(String s)
    {
        // Code here
        // we will use dp to solve the problem
        String s2="GEEKS";
        int n=s.length(), m=s2.length();
        int[][] dp=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        return getans(s,s2,n-1,m-1,dp,vis);
    }

    public int getans(String s,String s2,int i,int j,int[][] dp,boolean[][] vis){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        int ans=0;
        if(vis[i][j]){
            return dp[i][j];
        }
        if(s.charAt(i)==s2.charAt(j)){
            ans=(ans+getans(s,s2,i-1,j-1,dp,vis))%mod;
        }
        ans=(ans+getans(s,s2,i-1,j,dp,vis))%mod;
        vis[i][j]=true;
        return dp[i][j]=ans;
    }
}

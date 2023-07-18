package tricky;

public class longestRepeatingSubsequence {
    // it is clearly mentioned in the problem that the index of the i and j must not match for each of the characters in the strings s1 and string s2
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        // we have to find the longest repeating subsequence in the string
        // the two strings must have the characters different indices in a and b
        int n=str.length();
        boolean[][] vis=new boolean[n][n];
        int[][] dp=new int[n][n];
        return getans(str,str,n-1,n-1,dp,vis);
    }

    public int getans(String s1,String s2,int i,int j,int[][] dp,boolean[][] vis){
        if(i<0 || j<0){
            return 0;
        }

        if(vis[i][j]){
            return dp[i][j];
        }
        vis[i][j]=true;
        if(s1.charAt(i)==s2.charAt(j) && i!=j){
            return dp[i][j]=getans(s1,s2,i-1,j-1,dp,vis)+1;
        }
        else{
            return dp[i][j]=Math.max(getans(s1,s2,i-1,j,dp,vis),getans(s1,s2,i,j-1,dp,vis));
        }
    }
}

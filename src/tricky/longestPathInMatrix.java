package tricky;
import java.util.*;
public class longestPathInMatrix {
    public int longestIncreasingPath(int[][] mat)
    {
        // Code here
        // we have to dfs from the points and then we can reuse the paths that are alredy done using the dp array
        // the increasing subsequence till one point can be stored in the dp array to get the answer for the next adjacent elements
        // thus the answer will be in the dp array of size n*m
        // refer: https://youtu.be/wCc_nd-GiEc
        int n=mat.length, m=mat[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=getans(mat,i,j,dp,n,m);
                }
                ans=Math.max(ans,dp[i][j]);

            }
        }

        return ans;

    }

    public int getans(int[][] mat,int i,int j,int[][] dp,int n,int m){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int[] xi={1,0,-1,0};
        int[] yi={0,1,0,-1};
        int val=Integer.MIN_VALUE;
        for(int i1=0;i1<4;i1++){
            if(isbd(i+xi[i1],j+yi[i1],n,m) && mat[i+xi[i1]][j+yi[i1]]>mat[i][j]){
                val=Math.max(val,1+getans(mat,i+xi[i1],j+yi[i1],dp,n,m));
            }
        }
        if(val==Integer.MIN_VALUE){
            val=1;
        }
        dp[i][j]=val;
        return val;
    }

    public boolean isbd(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}

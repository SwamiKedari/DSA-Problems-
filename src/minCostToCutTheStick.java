
import java.util.*;

class minCostToCutTheStick {
    public int minCost(int n, int[] cuts) {
        // we have to cut the stick into the parts such that the cost to cut the stick would be minimum
        int[] cut=new int[cuts.length+2];
        int m=cuts.length;
        cut[0]=0;
        for(int i=0;i<m;i++){
            cut[i+1]=cuts[i];
        }
        cut[m+1]=n;
        Arrays.sort(cut);
        int[][] dp=new int[m+2][m+2];
        return getMin(cut,1,m,dp);

    }

    public int getMin(int[] cut,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            mini=Math.min(getMin(cut,i,k-1,dp) + getMin(cut,k+1,j,dp) + cut[j+1]-cut[i-1], mini);
        }

        dp[i][j]=mini;
        return dp[i][j];
    }
}
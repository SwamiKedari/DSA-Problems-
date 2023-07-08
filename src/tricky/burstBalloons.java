package tricky;

public class burstBalloons {
    public static int maxCoins(int n,int[] a) {
        // code here
        // we will use the dp on partitions to solve this problem
        // the idea is to go reverse and from the state that consists of the last balloon and then come to the first states
        // think in the way that there are many ways to do the partitions in the array and then max value of all this values can be achieved using the dp array

        int[] b=new int[n+2];
        int ind=1;
        for(int i=0;i<n;i++){
            b[ind]=a[i];
            ind++;
        }
        b[0]=1; b[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        int ans=maxval(1,n,b,dp);
        return ans;

    }

    public static int maxval(int i,int j,int[] a,int[][] dp){
        if(i>j){
            return 0;


        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int min=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){
            int cost=maxval(i,k-1,a,dp)+maxval(k+1,j,a,dp)+a[i-1]*a[k]*a[j+1];
            min=Math.max(cost,min);
        }
        dp[i][j]=min;
        return min;
    }
}

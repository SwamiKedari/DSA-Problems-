public class maximumSumIncreasingSubsequence {
    public int maxSumIS(int[] a, int n)
    {
        //code here.
        // we will use the space optimization code for the problem for further decreasing the space to o(n)
        // the below solution is the recursion + memoization solution
        // we will keep a one more variable which will keep of whether what the previous element is
        int[][] dp=new int[n][n+1];
        return getMax(a,dp,n-1,n,n);
    }

    public int getMax(int[] a,int[][] dp,int i,int preInd,int n){
        if(i==0){
            if(preInd>=n || a[preInd]>a[i]){
                return a[i];
            }
            return 0;
        }
        if(dp[i][preInd]>0){
            return dp[i][preInd];
        }
        int take=0,notTake=0;
        if(preInd>=n || a[preInd]>a[i]){
            take=getMax(a,dp,i-1,i,n)+a[i];
        }

        notTake=getMax(a,dp,i-1,preInd,n);

        dp[i][preInd]=Math.max(notTake,take);
        return dp[i][preInd];
    }
}

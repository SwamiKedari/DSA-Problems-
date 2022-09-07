public class longestBitonicSubsequence {
    public int LongestBitonicSequence(int[] a)
    {
        // Code here
        // this question is similar to the longest increasing subsequence problem with the condition that there will be a sign change in between the subsequence at most one
        // we can use a 3d array to solve this problem
        int n=a.length;
        int[][][] dp=new int[n][n+1][2];
        return getLong(a,0,-1,0,n,dp);

    }

    public int getLong(int[] a,int i,int pr,int sign,int n,int[][][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][pr+1][sign]>0){
            return dp[i][pr+1][sign];
        }
        int notTake=getLong(a,i+1,pr,sign,n,dp);
        int take=Integer.MIN_VALUE;
        if(sign==0 && (pr==-1 || a[i]>a[pr])){
            int change=1+getLong(a,i+1,i,1,n,dp);
            int notChange=1+getLong(a,i+1,i,0,n,dp);
            take=Math.max(change,notChange);
        }
        else if(sign==1 && (pr==-1 || a[i]<a[pr])){
            take=1+getLong(a,i+1,i,1,n,dp);
        }
        dp[i][pr+1][sign]=Math.max(notTake,take);
        return dp[i][pr+1][sign];
    }

}

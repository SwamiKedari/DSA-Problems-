public class longestIncreasingSubsequence {
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // time complexity is o nlogn
        // we have to find the longest increasing subsequence , we can use the dp array to get the answer
        int[][] dp=new int[size][size+1];

        return getLong(a,0,size,-1,dp);

    }

    public static int getLong(int[] a,int i,int n,int pr,int[][] dp){
        int take=Integer.MIN_VALUE;
        if(i==n){
            return 0;
        }
        if( dp[i][pr+1]>0){
            return dp[i][pr+1];
        }
        int notTake=getLong(a,i+1,n,pr,dp);
        if(pr==-1 || a[i]>a[pr]){
            take=1+getLong(a,i+1,n,i,dp);
        }
        dp[i][pr+1]=Math.max(take,notTake);
        return dp[i][pr+1];

    }
}

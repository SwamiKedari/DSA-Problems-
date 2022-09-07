public class longestSubsequenceWithAdjacentElementDifferenceEqualToOne {
    static int longestSubsequence(int n,int[] a)
    {
        // code here
        // this question is similar to the longest increasing subsequence problem where we pass the previous element to the next recursion
        // in this question also , we will pass the previous element index to the next
        // then we will make comparisons to know whether the absolute difference between the element and previous is one and return the max of the 2 cases
        // the tabulation and the space optimised code will be similar to the longest increasing subsequence
        int[][] dp=new int[n][n+1];
        return getLong(a,0,n,-1,dp);
    }

    static int getLong(int[] a,int i,int n,int pr,int[][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][pr+1]>0){
            return dp[i][pr+1];
        }
        int take=Integer.MIN_VALUE;
        int notTake=getLong(a,i+1,n,pr,dp);
        if(pr==-1 || Math.abs(a[i]-a[pr])==1){
            take=1+getLong(a,i+1,n,i,dp);
        }
        dp[i][pr+1]= Math.max(take,notTake);
        return dp[i][pr+1];
    }
}

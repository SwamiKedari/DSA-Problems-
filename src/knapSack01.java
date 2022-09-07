public class knapSack01 {
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n)
    {
        // your code here
        // this is a dynamic programming based problem
        // we will use the memoization solution
        int i=n-1;
        int[][] dp=new int[n][w+1];
        return getMax(val,wt,dp,n-1,w);
    }
    static int getMax(int[] val,int[] wt,int[][] dp,int i,int w){
        if(i==0){
            if(w>=wt[i] && val[i]>0){
                return val[i];
            }
            return 0;
        }

        if(dp[i][w]>0){
            return dp[i][w];
        }
        int notTake=getMax(val,wt,dp,i-1,w);
        int take=Integer.MIN_VALUE;
        if(w>=wt[i]){
            take=getMax(val,wt,dp,i-1,w-wt[i]) + val[i];
        }
        dp[i][w]=Math.max(notTake,take);
        return dp[i][w];
    }
}

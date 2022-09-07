public class perfectSumProblem {
    public int perfectSum(int a[],int n, int sum)
    {// doubt
        // Your code goes here

        // we will use the recursive code and then transform it to the dp
        // in this question , we first made a o(2^n) solution and then converted it to the o(n*sum) solution
        // we made the recursion from the start rather than the behind

        int[][] dp = new int[n][sum+1];
        boolean[][] visited=new boolean[n][sum+1];
        return getCount(a,dp,visited,0,0,sum);

    }
    public int getCount(int[] a,int[][] dp,boolean[][] visited,int i,int k,int sum){
        if(i==a.length){
            if(k==sum){
                return 1;
            }
            return 0;
        }
        if(visited[i][k]){
            return dp[i][k];
        }
        k+=a[i];
        int take=0;
        if(k<=sum){
            take=getCount(a,dp,visited,i+1,k,sum)%1000000007;
        }
        k-=a[i];
        int notTake=getCount(a,dp,visited,i+1,k,sum)%1000000007;
        dp[i][k]=take%1000000007+notTake%1000000007;
        visited[i][k]=true;
        return dp[i][k]%1000000007;
    }
}

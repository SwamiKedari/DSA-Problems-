public class goldMineProblem {
    static int maxGold(int n, int m,int[][] a)
    {
        // code here
        // this is a dynamic programming based problem
        // we will use the recursion + memoization solution to solve this problem
        int[][] dp=new int[n][m];
        int max=0;
        for(int k=0;k<n;k++){
            int h=getMax(a,dp,k,m-1,n,m);
            if(h>max){
                max=h;
            }
        }
        return max;

    }

    static int getMax(int[][] a,int[][] dp,int i,int j,int n,int m){
        if(i>=n || i<0){
            return Integer.MIN_VALUE;
        }
        if(j==0){
            return a[i][j];
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int a1=getMax(a,dp,i-1,j-1,n,m);
        int a2=getMax(a,dp,i,j-1,n,m);
        int a3=getMax(a,dp,i+1,j-1,n,m);
        dp[i][j]=Math.max(a1,(Math.max(a2,a3)))+a[i][j];
        return dp[i][j];
    }
}

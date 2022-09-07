public class numberOfPaths {
    // in this problem , we find the total paths from the top left to the bottom right in o(m*n) time complexity
    // it is similar to number of unique paths problem but we used dp array to optimize it

    long numberOfPaths(int m, int n)
    {
        // code here
        // this is a dynamic programming problem which we get using the recursion of the problem
        // we convert the recursion to dp solution by using a dp array
        // we can further optimize it by space optimization
        long[][] dp=new long[m][n];
        return getPaths(dp,m-1,n-1);
    }

    long getPaths(long[][] dp,int m,int n){
        if(m==0 || n==0 ){
            return 1;
        }
        if(dp[m][n]>0){
            return dp[m][n];
        }
        long a = getPaths(dp,m-1,n)%1000000007;
        long b= getPaths(dp,m,n-1)%1000000007;
        dp[m][n]=a+b;
        return dp[m][n]%1000000007;
    }
}

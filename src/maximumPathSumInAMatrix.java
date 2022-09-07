public class maximumPathSumInAMatrix {
    // this is a dynamic programming based answer which stores the max sum till the previous paths in an dp array
    // time complexity - o(m*n)
    // space complexity - o(m*n)
    // we can further space optimize the solution to make it o(n)
    static int maximumPath(int n,int[][] m)
    {
        // code here
        int[][] dp=new int[n][n];
        int max=0;
        for(int i=0;i<n;i++){
            int k=getMax(m,dp,n-1,i,n);
            //System.out.println(k+"((");
            if(k>max){
                max=k;
            }
        }
        return max;

    }
    static int getMax(int[][] m,int[][] dp,int i,int j,int n){
        if(i==0 && j<n && j>-1){
            return m[i][j];
        }
        if(i==-1 || j==-1 || i>=n || j>=n){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }

        int a=getMax(m,dp,i-1,j-1,n);
        int a1=getMax(m,dp,i-1,j,n);
        int a2=getMax(m,dp,i-1,j+1,n);

        //System.out.println(a+" "+a1+" "+a2);
        //System.out.println(i+"*"+j);
        dp[i][j]= Math.max(a,Math.max(a1,a2))+m[i][j];
        if(dp[i][j]==Integer.MIN_VALUE){
            dp[i][j]=0;
        }
        //System.out.println(dp[i][j]);
        return dp[i][j];
    }
}

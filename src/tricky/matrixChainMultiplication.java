package tricky;

public class matrixChainMultiplication {
    static int matrixMultiplication(int n,int[] a)
    {
        // code here
        // we have to find the matrix chain multiplication of this matrix
        // we can multiply any of the adjacent matrix first, after we multiply the matrix, then the answer will be the sum of the left matrix , right matrix and the cur multiplication
        // refer to the notebook for this
        int[][] dp=new int[n][n];
        int ans=getans(1,n-1,a,dp);
        return ans;
    }

    static int getans(int i,int j,int[] a,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost=a[k]*a[i-1]*a[j]+getans(i,k,a,dp)+getans(k+1,j,a,dp);
            min=Math.min(cost,min);
        }
        dp[i][j]=min;
        return min;

    }
}

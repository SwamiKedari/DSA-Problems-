package tricky;

public class noofWays {
    static long arrangeTiles(int n){
        // code here
        // Given a value N. In how many ways you can construct a grid of size N x 4 using tiles of size 1 x 4.
        // we are given a value n , we have to find the grid of size n*4 using the tiles of size 1*4
        // if n is greater than 4, we can either take 4 plates and place them vertically , we can also place just one plate horizontally
        // if n is less than 4, we can only place horizontally
        // we will add all the ways
        long[] dp=new long[n+1];
        long ans=getans(n,dp);
        return ans;
    }

    static long getans(int n,long[] dp){
        if(n==0){
            return 1;
        }
        if(dp[n]>0){
            return dp[n];
        }
        long ans=0;
        if(n>=4){
            ans=getans(n-4,dp)+getans(n-1,dp);
        }
        else{
            ans=getans(n-1,dp);
        }
        return dp[n]=ans;
    }
}

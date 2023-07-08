package tricky;

public class paintingFences {
    long mod=(long)1e9+7;
    long countWays(int n,int k)
    {
        //code here.
        //for the explanation, see the love babbar solution
        long[] dp=new long[n+1];
        return f(n,k,dp);
    }

    long f(int n,int k,long[] dp){
        if(n==0){
            return 0;
        }
        if(n==1){
            return k;
        }
        if(n==2){
            return k+k*(k-1);
        }
        if(dp[n]>0){
            return dp[n];
        }

        return dp[n]=(f(n-1,k,dp)*(k-1)+f(n-2,k,dp)*(k-1))%mod;
    }
}

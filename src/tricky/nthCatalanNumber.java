package tricky;

public class nthCatalanNumber {
    public static int mod=(int)1e9+7;
    public static int findCatalan(int n) {
        // code here
        // we have to find the pattern among the catalan numbers
        // catalan numbers follow the following relation :
        // co=1, and cn+1= sum of cn-i*ci for i equal to 0 to n
        // thus we can use dp to optimize this solution and get answer
        if(n==0 || n==1){
            return 1;
        }
        long[] dp=new long[n+1];
        // boolean[] vis=new boolean[n+1];
        // return (int)getans(n,dp,vis)%mod;
        dp[0]=1; dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]=(dp[i]+(dp[j]*dp[i-j-1]))%mod;
                dp[i]%=mod;
            }
        }


        return (int)dp[n]%mod;
    }

    public static long getans(int n,long[] dp,boolean[] vis){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(vis[n]){
            return dp[n]%mod;
        }
        long sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+(getans(n-i-1,dp,vis)*getans(i,dp,vis))%mod)%mod;
        }
        vis[n]=true;
        return dp[n]=sum%mod;

    }
}

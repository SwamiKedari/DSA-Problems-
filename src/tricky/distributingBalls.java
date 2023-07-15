package tricky;

public class distributingBalls {
    static int mod=(int)1e9+7;
    static int countWays(int m, int n, int p, int a[])
    {
        // code here
        int to=m-p;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        // first we will satisfy all the children to make them happy and then distribute the remaining values among the n children like the coin distribution problem
        // thus this will give the answer
        // we will need to distribute the elements to the sum first to make them happy, after that, we can find the total ways to split the remaining m into n values
        if(sum>to){
            return -1;
        }
        else if(sum==to){
            return 1;
        }
        else{
            int val=to-sum;
            int[][] dp=new int[n][val+1];
            return getans(n-1,val,dp)%mod;
        }

    }

    static int getans(int i,int val,int[][] dp){
        if(val==0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][val]>0){
            return dp[i][val]%mod;
        }
        int a=(getans(i-1,val,dp)+getans(i,val-1,dp))%mod;

        return dp[i][val]=a%mod;

    }
}

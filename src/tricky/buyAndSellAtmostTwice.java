package tricky;

public class buyAndSellAtmostTwice {
    static int[][][] dp=new int[10][2][2];
    // in this question, we have used the 3d dp which has the following states i, buy/sell and the transactions done
    // this will help us to solve the problem
    // memoization solution was showing stackoverflow error, tabulation worked successfully 
    public static int maxProfit(int n, int[] a) {
        // code here
        // the dp will be the 3d dp with states i, buy/sell and transactions done
        dp=new int[n+1][2][3];

        // return getans(pr,0,1,0,n);
        // we will convert the given problem to the tabulation form
        for(int i=n;i>-1;i--){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    if(i==n || k==2){
                        continue;
                    }
                    if(j==1){
                        int val=dp[i+1][0][k]-a[i];
                        int val1=dp[i+1][1][k];
                        dp[i][j][k]=Math.max(val,val1);

                    }
                    else{
                        int val=dp[i+1][1][k+1]+a[i];
                        int val1=dp[i+1][0][k];
                        dp[i][j][k]=Math.max(val,val1);
                    }
                }
            }
        }

        return dp[0][1][0];

    }

    public static int getans(int[] a,int i,int isbuy,int cp,int n){
        if(i==n || cp==2){
            return 0;
        }
        if(dp[i][isbuy][cp]>0){
            return dp[i][isbuy][cp];
        }
        if(isbuy==1){
            int val=getans(a,i+1,0,cp,n)-a[i];
            int val1=getans(a,i+1,1,cp,n);
            dp[i][isbuy][cp]=Math.max(val,val1);
        }
        else{
            int val=getans(a,i+1,1,cp+1,n)+a[i];
            int val1=getans(a,i+1,0,cp,n);
            dp[i][isbuy][cp]=Math.max(val,val1);
        }

        return dp[i][isbuy][cp];
    }
}

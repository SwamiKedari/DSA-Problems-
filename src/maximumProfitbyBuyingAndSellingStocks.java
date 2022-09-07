public class maximumProfitbyBuyingAndSellingStocks {
    // check the dp project for all the 3 parts of dynamic programming
    // space optimised solution below
    static int maxProfit(int cap,int n,int[] a) {
        // code here
        // we will solve this problem using the dynamic programming
        // the upperlimit for the transactions will be k times
        int[][] prev=new int[2][cap+1];
        int[][] curr=new int[2][cap+1];
        for(int i=n-1;i>-1;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=cap;k++){
                    if(j==1){
                        int take=-1*a[i]+prev[0][k];
                        int notTake=prev[1][k];
                        curr[j][k]=Math.max(take,notTake);
                    }
                    else{
                        int take=a[i]+prev[1][k-1];
                        int notTake=prev[0][k];
                        curr[j][k]=Math.max(take,notTake);
                    }
                }

            }
            prev=curr;
            curr=new int[2][cap+1];
        }
        return prev[1][cap];
    }
}

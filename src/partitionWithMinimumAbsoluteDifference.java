public class partitionWithMinimumAbsoluteDifference {
    public int minDifference(int[] a,int n)
    {// doubt
        // Your code goes here
        // this is a dynamic programming based question
        // the tabulation part of this code will have the boolean values of whether the subset of sum with that value is present or not
        // the last row of the dp array which we used in the tabulation will have such boolean values
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][a[0]]=true;
        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                boolean notTake=dp[i-1][t];
                boolean take=false;
                if(t>=a[i]){
                    take=dp[i-1][t-a[i]];
                }
                dp[i][t]=take|notTake;
            }
        }
        int sum1=0;
        for(int i=sum/2;i<=sum;i++){
            if(dp[n-1][i]){
                sum1=i;
                break;
            }
        }

        return Math.abs(sum-sum1-sum1);
    }
}

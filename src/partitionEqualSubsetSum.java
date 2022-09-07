public class partitionEqualSubsetSum {
    // this is a dynamic programming based solution
    // we find whether there exists a subset which sums to half of the total sum
    // we used an dp array to reduce the time complexity from o(2^n) to o(n*sum/2)
    // check dp project in intellij for this method

    static int equalPartition(int n,int[] a)
    {
        // code here
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(sum%2==1){
            return 0;
        }
        int[][] dp=new int[n][sum/2+1];
        int[][] visited=new int[n][sum/2+1];
        return hasPartition(a,dp,visited,n-1,sum/2);
    }

    static int hasPartition(int[] a,int[][] dp,int[][] visited,int i,int s){
        if(s==0){
            return 1;
        }
        if(i==0){
            if(s==a[0]){
                return 1;
            }
            return 0;
        }
        if(visited[i][s]==1){
            return dp[i][s];
        }

        int take=0;
        if(s>=a[i]){
            take=hasPartition(a,dp,visited,i-1,s-a[i]);
        }
        int notTake=hasPartition(a,dp,visited,i-1,s);

        if(take+notTake>0){
            dp[i][s]=1;
            visited[i][s]=1;
            return 1;
        }
        dp[i][s]=0;
        visited[i][s]=1;
        return 0;
    }
}

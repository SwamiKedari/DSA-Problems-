public class subsetWithGivenSum {
    // this is a dynamic programming based solution which has time complexity o(n*sum)
    // is has space complexity o(n*sum)
    // check the dynamic programming project in intellij for the given problem
    static Boolean isSubsetSum(int n,int[] a,int s){
        // code here
        // we need to find if there exists a particular subset which has sum which sums to the given sum
        // we use dynamic programming to solve this problem
        boolean[][] dp=new boolean[n][s+1];
        boolean[][] visited=new boolean[n][s+1];
        return hasSubset(a,dp,visited,n-1,n,s);
    }

    static boolean hasSubset(int[] a,boolean[][] dp,boolean[][] visited,int i,int n,int s){
        if(s==0){
            return true;
        }
        if(i==0){
            return a[i]==s;
        }
        if(visited[i][s]){
            return dp[i][s];
        }
        boolean notTake=hasSubset(a,dp,visited,i-1,n,s);
        boolean take=false;
        if(s>=a[i]){
            take=hasSubset(a,dp,visited,i-1,n,s-a[i]);
        }
        dp[i][s]=take| notTake;
        visited[i][s]=true;
        return dp[i][s];
    }
}

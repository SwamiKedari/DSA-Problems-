package tricky;
import java.util.*;
public class findAllDistinctSubsequenceSum {
    public int[] DistinctSum(int[] a)
    {
        // Code here
        // we will use the subset with given sum problem to solve this problem and get the answer , we will pass the sum value as the total sum to the function and then find all the values in the dp table that has the value equal to 1
        // this will give us the answer
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        int n=a.length;
        int[][] dp=new int[n+1][sum+1];
        // we will find the subarray with sum equal to the total sum, in between we will find all the sums
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j>=a[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j-a[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        TreeSet<Integer> set=new TreeSet<>();
        for(int j=0;j<=sum;j++){
            if(dp[n][j]==1){
                set.add(j);
            }
        }

        int[] ans=new int[set.size()];
        int ind=0;
        for(int k: set){
            ans[ind]=k;
            ind++;
        }
        return ans;
    }

}

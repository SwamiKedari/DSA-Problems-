package tricky;
import java.util.*;
public class beautifulSequence {
    // Function for finding maximum and value pair
    public static int longest_Subsequence (int a[], int n) {
        //Complete the function
        //we will use two index dp solution to solve this problem
        //in this problem, we are asked to find the longest subsequence which have the elements which follow the following condition:
        //  for all (i,j) where i!=j either A[i] divides A[j] or vice versa. If no such sub-sequence exists then print -1.
        // based on the fact that if a divides b and b divides c, then a should also divide c
        // we sort the array and then find the answer by storing the pr element that we took and the current element present in the array

        Arrays.sort(a);
        int[][] dp=new int[n][n+1];

        int k=getans(a,0,-1,n,dp);
        if(k==1){
            return -1;
        }
        return k;

    }

    public static int getans(int[] a,int i,int pr,int n,int[][] dp){
        if(i==n || pr==n){
            return 0;
        }
        if(dp[i][pr+1]>0){
            return dp[i][pr+1];
        }
        int ans=0;
        if(pr==-1){
            ans=Math.max(getans(a,i+1,-1,n,dp),getans(a,i+1,i,n,dp)+1);
        }
        else{
            if(a[i]%a[pr]==0){
                ans=Math.max(getans(a,i+1,pr,n,dp),getans(a,i+1,i,n,dp)+1);
            }
            else{
                ans=getans(a,i+1,pr,n,dp);
            }
        }

        return dp[i][pr+1]=ans;
    }
}

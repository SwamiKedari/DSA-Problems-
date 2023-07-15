package tricky;

public class longestArithmeticProgressionSubsequence {
    int lengthOfLongestAP(int[] a, int n) {
        if(n<=2){
            return n;
        }
        // code here
        // we have kept the array as the dp[n][10000] as the constraints on the dp are from 1 to 10000
        int[][] dp=new int[n][10000];
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int diff=a[j]-a[i];
                if(dp[i][diff]==0){ // if the value of the dp[i][diff] is 0, it means that i and j are the first two elements of the dp and so, dp[j][dif]=2
                    dp[j][diff]=2;
                }
                else{
                    dp[j][diff]=dp[i][diff]+1; // if it is not 0, it means that the value of the dp[i][diff] is the length of the subsequence till i with difference d, thus we are adding an extra element to the array
                }
                ans=Math.max(dp[j][diff],ans);
            }
        }

        return ans;
    }
}

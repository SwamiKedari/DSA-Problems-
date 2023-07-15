package tricky;

public class longestSubsequenceSubstringProblem {
    int maxSubsequenceSubstring(String x,String y,int n,int m)
    {
        // code here
        // we have to find the longest subsequence of the string x which is the substring in the sequence y
        // we can solve this problem using the dp
        // if both the characters are same, then we will move both i to i-1 and j to j-1 , when they are not same, we will keep the j character same and move the i index
        // for the substring part, we will use a for loop to set all the back characters in the main solution
        int[][] dp=new int[n][m];
        int val=Integer.MIN_VALUE;
        for(int i=m-1;i>-1;i--){
            val=Math.max(f(x,y,n-1,i,dp),val);
        }
        return val;
    }

    int f(String x,String y,int i,int j,int[][] dp){

        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int ans=0;
        int ct1=0, ct2=0;
        if(x.charAt(i)==y.charAt(j)){
            ct1=f(x,y,i-1,j-1,dp)+1;
        }
        else{
            ct2=f(x,y,i-1,j,dp);
        }
        ans=Math.max(ct1,ct2);
        return dp[i][j]=ans;
    }
}

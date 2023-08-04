package tricky;

public class countPalindromicSubsequences
{

    long mod=(long)1e9+7;

    /*
            Initial Values : i= 0, j= n-1;

        CountPS(i,j)
        // Every single character of a string is a palindrome
        // subsequence
        if i == j
           return 1 // palindrome of length 1

        // If first and last characters are same, then we
        // consider it as palindrome subsequence [(a___a) is one palindromice subsequence of (abcba)] and check
        we will consider this subsequence as one count and then we will find the rest subsequences that are present
        // for the rest subsequence (i+1, j), (i, j-1)
        Else if (str[i] == str[j])
           return   countPS(i+1, j) + countPS(i, j-1) + 1;

        else
           // check for rest sub-sequence and  remove common
           // palindromic subsequences as they are counted
           // twice when we do countPS(i+1, j) + countPS(i,j-1)
           return countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1)
     */
    long countPS(String s)
    {
        // Your code here
        // we have to find the no of palindromic subsequences present in the string
        // we will use two indices, one in the front, one in the back
        // then the logic for the code will be as follows in the code
        int n=s.length();
        long[][] dp=new long[n][n];
        boolean[][] vis=new boolean[n][n];
        return getans(s,0,n-1,dp,vis)%mod;
    }

    long getans(String s,int i,int j,long[][] dp,boolean[][] vis){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(vis[i][j]){
            return dp[i][j]%mod;
        }
        vis[i][j]=true;
        if(s.charAt(i)==s.charAt(j)){
            long ans=1;
            ans=(ans+getans(s,i+1,j,dp,vis))%mod;
            ans=(ans+getans(s,i,j-1,dp,vis))%mod;
            return dp[i][j]=ans;
        }
        else{
            long ans=0;
            ans=(ans+getans(s,i+1,j,dp,vis))%mod;
            ans=(ans+getans(s,i,j-1,dp,vis))%mod;
            ans=(ans-getans(s,i+1,j-1,dp,vis))%mod; // since the operation can take the answer to lesser than zero, we will bring back it to the 0 to mod-1 range by adding +m
            // if the mod of the no is negative, we need to add +mod to it
            if(ans<0){
                ans+=mod;
            }
            return dp[i][j]=ans;
        }
    }
}
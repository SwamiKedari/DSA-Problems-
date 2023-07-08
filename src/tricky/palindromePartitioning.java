package tricky;

public class palindromePartitioning {
    static int palindromicPartition(String s)
    {
        // code here
        // we can cut the string at each point, everytime we cut the string, we check if it is palindrome or not
        // if it is palindrome, we can return 0 from their, as this string will not require any further cuts
        // we will use the dp on partitions to solve this problem
        // i will be the start index and j will be the end index
        int n=s.length();
        int[][] dp=new int[n][n];
        return getans(s,0,n-1,dp);
    }

    static int getans(String s,int i,int j,int[][] dp){
        if(ispal(s,i,j)){
            return 0;
        }
        // we can make the cuts between any points between i and j
        // we will use the for loop for making the cuts
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int ct=(int)1e9;
        for(int k=i+1;k<=j;k++){
            int cost=getans(s,i,k-1,dp)+getans(s,k,j,dp)+1;
            ct=Math.min(ct,cost);
        }
        return dp[i][j]=ct;
    }
    static boolean ispal(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

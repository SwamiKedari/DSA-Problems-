public class editDistance {// no clear description
    public int editDistance(String s, String t) {
        // Code here
        // we will use dynamic programming to solve this question
        // when there is a character match , we will both move by one index
        // else we will take the minimum of all the values we get by performing the operations
        int n=s.length() , m=t.length();
        int[][] dp=new int[n][m];
        return getMin(s,t,n-1,m-1,dp);
        // for the tabulation and the space optimisation part , look into the dp series
        // this answer includes the recursion + memoization part only
    }

    public int getMin(String s,String t,int n,int m,int[][] dp){
        if(m<0){
            return n+1;
        }
        if(n<0){
            return m+1;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(s.charAt(n)==t.charAt(m)){
            dp[n][m]= getMin(s,t,n-1,m-1,dp);
            return dp[n][m];
        }
        else{
            int k=getMin(s,t,n,m-1,dp); // for insertion
            int g=getMin(s,t,n-1,m,dp); // for deletion
            int h=getMin(s,t,n-1,m-1,dp); // for replacement
            dp[n][m]=Math.min(Math.min(k,g),h)+1;
            return dp[n][m];
        }
    }
}

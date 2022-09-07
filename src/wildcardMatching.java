public class wildcardMatching {
    // this is the dynamic programming based question submitted in the geeks for geeks
    // the tabulation code got submitted correctly
    // for the space optimised part , look into dp project
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int n=pattern.length();
        int m=str.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            dp[0][i]=false;
        }
        for(int i=1;i<=n;i++){
            dp[i][0]=isstar(pattern,i);
        }

        //System.out.println(Arrays.toString(dp[0]));

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(pattern.charAt(i-1)==str.charAt(j-1) || pattern.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pattern.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        if(dp[n][m]){
            return 1;
        }
        return 0;

    }

    boolean isstar(String pattern , int i){
        for(int j=0;j<=i-1;j++){
            if(pattern.charAt(j)!='*'){
                return false;
            }
            //return true;
        }
        return true;
    }

    // the recursion +memoization part of the code didnot work and so we will use the tabulation part of the code


    public static boolean ismatch(String s1,String s2,int n,int m,boolean[][] dp){
        /*
        the base case for the recursion is as follows :
        1) if the string s1 gets exhausted
        2) if the string s2 gets exhausted
        if both the strings get exhausted  , we return true
        if s1 gets exhausted and s2 didnot exhaust , in this case we will return false
        if s2 gets exhausted and s1 didnot exhaust , we will check if the s1 will have all the stars , if it have all the stars , we will return true , else we will return false

         */

        if(n<0 && m<0){
            return true;
        }
        if(n<0 && m>=0){
            return false;
        }
        if(m<0 && n>=0){
            for(int i=0;i<=n;i++){
                if(s1.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[n][m]){
            return dp[n][m];
        }

        if(s1.charAt(n)==s2.charAt(m) || s1.charAt(n)=='?'){
            dp[n][m]= ismatch(s1,s2,n-1,m-1,dp);
            return dp[n][m];
        }
        else{
            dp[n][m]=ismatch(s1,s2,n-1,m,dp) || ismatch(s1,s2,n,m-1,dp);
            return dp[n][m];
        }
    }
}

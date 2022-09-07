public class LCSOfThreeStrings {
    // in this question , we have to find the length of the longest common subsequence of the 3 strings
    int LCSof3(String a, String b, String c, int n1, int n2, int n3)
    {
        // code here
        // this question is similar to the longest common subsequence problem
        // we have to consider all the cases for solving this problem
        /*
        when all the three strings match , we will move all the indexes of all the strings to left
        if 2 match , we will move the index of one which is not matched
        if none matches , then we will move the indexes of any two strings out of the three
        */
        //int[][][] dp=new int[n1][n2][n3];
        // return getLong(a,b,c,n1-1,n2-1,n3-1,dp);
        // memoization solution did not satisfy the time complexity of the solution

        int[][][] dp=new int[n1+1][n2+1][n3+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                for(int k=1;k<=n3;k++){
                    if(ismatch(a,b,i-1,j-1) && ismatch(a,c,i-1,k-1)){
                        dp[i][j][k]=1+dp[i-1][j-1][k-1];
                    }
                    else if(ismatch(a,b,i-1,j-1)){
                        int t=dp[i-1][j-1][k];
                        int g=dp[i][j][k-1];
                        dp[i][j][k]=Math.max(t,g);
                    }
                    else if(ismatch(a,c,i-1,k-1)){
                        int t=dp[i-1][j][k-1];
                        int g=dp[i][j-1][k];
                        dp[i][j][k]=Math.max(t,g);
                    }
                    else if(ismatch(c,b,k-1,j-1)){
                        int t=dp[i][j-1][k-1];
                        int g=dp[i-1][j][k];
                        dp[i][j][k]=Math.max(t,g);
                    }
                    else{
                        int t=dp[i][j-1][k-1];
                        int g=dp[i-1][j][k-1];
                        int k1=dp[i-1][j-1][k];
                        dp[i][j][k]=Math.max(Math.max(t,g),k1);
                    }

                }
            }
        }
        return dp[n1][n2][n3];

    }

    int getLong(String a,String b,String c,int n1,int n2,int n3,int[][][] dp){
        if(n1<0 || n2<0 || n3<0){
            return 0;
        }
        if(dp[n1][n2][n3]>0){
            return dp[n1][n2][n3];
        }
        if(ismatch(a,b,n1,n2) && ismatch(a,c,n1,n3)){
            dp[n1][n2][n3]= 1+getLong(a,b,c,n1-1,n2-1,n3-1,dp);
            return dp[n1][n2][n3];
        }
        else if(ismatch(a,b,n1,n2)){
            int t=getLong(a,b,c,n1-1,n2-1,n3,dp);
            int g=getLong(a,b,c,n1,n2,n3-1,dp);
            dp[n1][n2][n3]=Math.max(t,g);
            return dp[n1][n2][n3];
        }
        else if(ismatch(a,c,n1,n3)){
            int t=getLong(a,b,c,n1-1,n2,n3-1,dp);
            int g=getLong(a,b,c,n1,n2-1,n3,dp);
            dp[n1][n2][n3]=Math.max(t,g);
            return dp[n1][n2][n3];
        }
        else if(ismatch(c,b,n3,n2)){
            int t=getLong(a,b,c,n1,n2-1,n3-1,dp);
            int g=getLong(a,b,c,n1-1,n2,n3,dp);
            dp[n1][n2][n3]=Math.max(t,g);
            return dp[n1][n2][n3];
        }
        else{
            int t=getLong(a,b,c,n1-1,n2-1,n3,dp);
            int g=getLong(a,b,c,n1,n2-1,n3-1,dp);
            int k=getLong(a,b,c,n1-1,n2,n3-1,dp);
            dp[n1][n2][n3]=Math.max((Math.max(t,g)),k);
            return dp[n1][n2][n3];
        }
    }
    boolean ismatch(String a,String b,int i,int j){
        return a.charAt(i)==b.charAt(j);
    }
}

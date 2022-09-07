public class formAPalindromeUsingMinInsertions {
    static int countMin(String str)
    {
        // this problem is the dp problem , we will just find the longest palindromic subsequeuence and then do the difference with the current string size

        // code here
        // the approach to solve this problem is simple , we need to find the characters in the longest palindromic subsequence and the difference between the len of that subsequence and the main string will be the answer
        StringBuilder a=new StringBuilder();
        int n=str.length();
        for(int i=n-1;i>-1;i--){
            a.append(str.charAt(i));
        }
        String st=String.valueOf(a);
        int[][] dp=new int[n][n];
        int palLen=getPalLength(str,st,dp,n-1,n-1);
        return n-palLen;
        // we can further optimise the code by using tabulation and space optimisation
    }

    static int getPalLength(String st,String str,int[][] dp,int x,int y){
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]>0){
            return dp[x][y];
        }
        if(st.charAt(x)==str.charAt(y)){
            dp[x][y]= 1+getPalLength(st,str,dp, x-1,y-1);
            return dp[x][y];
        }

        dp[x][y]=Math.max(getPalLength(st,str, dp,x-1,y),getPalLength(st,str,dp, x,y-1));
        return dp[x][y];

    }
}

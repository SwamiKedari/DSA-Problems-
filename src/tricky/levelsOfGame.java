package tricky;

public class levelsOfGame {
    // this is different dp question in which greedy approach to take the third state first and then either of the alternate 1st and the 2nd state along waith the 3rd state is optimal approach

    public static int maxLevel(int h,int m) {
        // code here
        // since the third state will be taken every alternate step for maximum levels
        int[][] dp=new int[1000][1000];
        return getans(h+3,m+2,dp)+1; //the first state that we will take will be 3rd one
    }

    public static int getans(int h,int m,int[][] dp){
        if(h<=0 || m<=0){
            return 0;
        }
        if(dp[h][m]>0){
            return dp[h][m];
        }
        int take1and3=0, take2and3=0;
        if(h>20){
            take1and3=getans(h-20+3,m+5+2,dp)+2;
        }
        if(h>5 && m>10){
            take2and3=getans(h-5+3,m-10+2,dp)+2;
        }
        return dp[h][m]=Math.max(take1and3,take2and3);
    }
}

package tricky;

public class potsOfGoldGame {
    // during the x turn, he will try to maximize the score and during the y turn, he will try to minimize the score
    // we will add the values during the x turn only to the answer
    // one pointer will be in the front and one in the back
    // this will give the max ans for the answer which denotes the x score
    public static int maxCoins(int a[],int n)
    {
        //add code here.
        // we will add a pointer to the front and one to the back
        // second variable will be the turn denoting the person who has the current turn
        int[][][] dp=new int[n][n][2];
        boolean[][][] vis=new boolean[n][n][2];
        int val=getmax(a,0,n-1,0,dp,vis);
        return val;
    }

    public static int getmax(int[] a,int i,int j,int t,int[][][] dp,boolean[][][] vis){
        if(i>j){
            return 0;
        }
        if(vis[i][j][t]){
            return dp[i][j][t];
        }
        vis[i][j][t]=true;
        if(t==0){
            int val1=getmax(a,i+1,j,1,dp,vis)+a[i];
            int val2=getmax(a,i,j-1,1,dp,vis)+a[j];
            return dp[i][j][t]=Math.max(val1,val2);
        }
        else{
            int val1=getmax(a,i+1,j,0,dp,vis);
            int val2=getmax(a,i,j-1,0,dp,vis);
            return dp[i][j][t]=Math.min(val1,val2);
        }
    }
}

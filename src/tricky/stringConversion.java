package tricky;

public class stringConversion {
    int stringConversion(String x,String y) {
        // code here
        // we will use dp to solve this problem
        // check all the possibilities using the recursion
        // name String Conversion
        int n=x.length(), m=y.length();
        for(int i=0;i<m;i++){
            if(islow(y.charAt(i))){
                return 0;
            }
        }
        int[][] dp=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        return getans(x,y,n-1,m-1,dp,vis);
    }

    int getans(String x,String y,int i,int j,int[][] dp,boolean[][] vis){
        if(i==-1 && j==-1){
            return 1;
        }
        if(i<0){
            return 0;
        }
        else if(j<0){
            int k=1;
            for(int ind=0;ind<=i;ind++){
                if(!islow(x.charAt(ind))){
                    return 0;
                }
            }
            return 1;
        }
        if(vis[i][j]){
            return dp[i][j];
        }
        vis[i][j]=true;
        if((x.charAt(i)==y.charAt(j))){
            return dp[i][j]=getans(x,y,i-1,j-1,dp,vis);
        }
        else if(!islow(x.charAt(i))){
            return dp[i][j]=0;
        }
        else if(islow(x.charAt(i)) && x.charAt(i)-y.charAt(j)==32){
            return dp[i][j]=Math.max(getans(x,y,i-1,j-1,dp,vis),getans(x,y,i-1,j,dp,vis));
        }
        else{
            return dp[i][j]=getans(x,y,i-1,j,dp,vis);
        }

    }

    boolean islow(char ch){
        if(ch>=97){
            return true;
        }
        return false;
    }
}

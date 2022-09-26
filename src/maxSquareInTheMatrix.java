public class maxSquareInTheMatrix {
    // in this problem , we have to find the maximum area of any square in the 2 d matrix

    static int maxSquare(int n, int m, int mat[][]){
        // code here
        // in this problem , we find the largest square using the tabulation form of the code

        int[][] dp=new int[n][m];
        int count=0;
        for(int i=0;i<m;i++){
            dp[0][i]=mat[0][i];
            if(dp[0][i]==1){
                count++;
            }
        }
        for(int i=0;i<n;i++){
            dp[i][0]=mat[i][0];
            if(dp[i][0]==1){
                count++;
            }
        }

        int max=1;

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    count++;
                }
                else{
                    dp[i][j]=0;
                }
                if(max<dp[i][j]){
                    max=dp[i][j];
                }
            }
        }
        if(count>0){
            return max;
        }
        return 0;
    }
}

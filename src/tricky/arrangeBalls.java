package tricky;

public class arrangeBalls {
    public int mod=(int)1e9+7;
    // we can solve this problem using the 4 dp array and find all the answers that are present in the array

    public int CountWays(int p, int q, int r)
    {
        // code here
        int[][][][] dp=new int[p+1][q+1][r+1][3];
        boolean[][][][] vis=new boolean[p+1][q+1][r+1][3];
        return ((getans(p-1,q,r,0,dp,vis)+getans(p,q-1,r,1,dp,vis))%mod+getans(p,q,r-1,2,dp,vis))%mod;

    }

    public int getans(int p,int q,int r,int cur,int[][][][] dp,boolean[][][][] vis){
        if(p<1 && q<1 && r<1){
            return 1;
        }
        if(vis[p][q][r][cur]){
            return dp[p][q][r][cur]%mod;
        }
        int ans=0;
        if(cur==0){
            if(q>0){
                ans=(ans+getans(p,q-1,r,1,dp,vis))%mod;
            }
            if(r>0){
                ans=(ans+getans(p,q,r-1,2,dp,vis))%mod;
            }
        }
        else if(cur==1){
            if(p>0){
                ans=(ans+getans(p-1,q,r,0,dp,vis))%mod;
            }
            if(r>0){
                ans=(ans+getans(p,q,r-1,2,dp,vis))%mod;
            }
        }
        else{
            if(q>0){
                ans=(ans+getans(p,q-1,r,1,dp,vis))%mod;
            }
            if(p>0){
                ans=(ans+getans(p-1,q,r,0,dp,vis))%mod;
            }
        }
        vis[p][q][r][cur]=true;
        dp[p][q][r][cur]=ans%mod;
        return dp[p][q][r][cur]%mod;
    }
}

package tricky;

public class possiblePathsWithKEdgesBetweenAAndB {
    class Solution
    {
        public int mod=(int)1e9+7;
        public int MinimumWalk(int[][] g, int u, int v, int k)
        {
            // Code here
            // we have to find the total vertices with the k edges in between them
            // think this question in terms of dp, where we need to explore all the paths, and also store this paths in the memoized dp array to get the answer
            // we dont need a vis array over here since dp array is used. 
            int n=g.length;
            int[][] dp=new int[n][k+1];
            return dfs(g,u,k,v,dp);
        }

        public int dfs(int[][] g,int u,int k,int v,int[][] dp){
            if(k==0 && u!=v){
                return 0;
            }
            if(k==0){
                return 1;
            }
            if(dp[u][k]>0){
                return dp[u][k];
            }
            int ans=0;
            for(int i=0;i<g.length;i++){
                if(g[u][i]==1){
                    ans=(ans+dfs(g,i,k-1,v,dp))%mod;
                }
            }

            dp[u][k]=ans;
            return ans;
        }
    }
}

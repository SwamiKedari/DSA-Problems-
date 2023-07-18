package tricky;

public class waysToSumToN {
    public int mod=(int)1e9+7;
    // since the first element can be any of the m elements, we can use a for loop inside the recursive function to get the answer

    public int countWays(int[] ar,int m,int n)
    {
        // lets first make the recurisve solution for this problem,
        // at each place we are using each and every element, thus we will use all the elements in the aray each time
        // after that we will use them to solve
        // since the first element in the combinations can be each of the m elements, we will need a forloop inside the recursive function
        // this will help us to get the answer
        int[] dp=new int[n+1];
        boolean[] vis=new boolean[n+1];
        return getans(ar,n,m,dp,vis)%mod;

    }

    public int getans(int[] a, int n,int m,int[] dp,boolean[] vis){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(vis[n]){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<m;i++){
            ans=(ans+getans(a,n-a[i],m,dp,vis))%mod;
        }
        vis[n]=true;
        return dp[n]=ans%mod;
    }
}

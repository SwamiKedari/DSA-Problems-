package tricky;

public class minimumTime {
    int[] dp=new int[1];
    boolean[] vis=new boolean[1];
    public int minTimeForWritingChars(int n,int i,int d,int c)
    {
        // Your code goes here
        // we are given with the i, d and c which are the times required for the insertion, deletion and the copy operation respectively
        // this can be done using recursion
        // we will delete the character only when the current length is odd , so we will do the delete and then copy paste at the same time
        // this will give us the optimal approach for solving

        dp=new int[n+1];
        vis=new boolean[n+1];
        return f(n,i,d,c);
    }

    public int f(int n,int i,int d,int c){
        if(n==0){
            return 0;
        }
        if(n<0){
            return (int)1e6;
        }
        if(vis[n]){
            return dp[n];
        }
        int it=Integer.MAX_VALUE, dt=Integer.MAX_VALUE, ct=Integer.MAX_VALUE;
        if(n%2==0){
            it=f(n-1,i,d,c)+i;
            ct=f(n/2,i,d,c)+c;
        }
        else{
            it=f(n-1,i,d,c)+i;
            if(n!=1){
                dt=f((n+1)/2,i,d,c)+d+c;
            }
        }
        vis[n]=true;
        return dp[n]=Math.min(it,Math.min(dt,ct));
    }
}

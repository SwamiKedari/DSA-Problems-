package tricky;
import java.util.*;
public class villainCon{
    static int minColour(int n,int m,int[][] a) {
        // code here
        // topo-sort algorithm + dp algorithm // dp to store the current length from that node
        // after doing the topo sort , the nodes will be arranged in the order
        // after that , we can use the current max length from a particular node that is precomputed directly to get the asnwer
        // this will help traverse the array in O(n+m) time
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<=n;i++){
            ar.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            int u=a[i][0], v=a[i][1];
            ar.get(u).add(v);
        }
        // we will use dfs to get the topo sort
        Stack<Integer> st=new Stack<Integer>();
        boolean[] vis=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(ar,i,vis,st);
            }
        }
        int[] dp=new int[n+1];
        vis=new boolean[n+1];
        int min=Integer.MIN_VALUE;
        while(!st.isEmpty()){
            int k=st.pop();
            min=Math.max(getans(ar,k,vis,dp),min);
        }

        return min;


    }

    static int getans(ArrayList<ArrayList<Integer>> ar,int i,boolean[] vis,int[] dp){
        if(vis[i]){
            return dp[i];
        }
        int len=1;
        for(int k: ar.get(i)){
            len=Math.max(len,1+getans(ar,k,vis,dp));
        }
        vis[i]=true;
        dp[i]=len;
        return dp[i];
    }

    static void dfs(ArrayList<ArrayList<Integer>> ar,int i,boolean[] vis,Stack<Integer> st){
        vis[i]=true;
        for(int k: ar.get(i)){
            if(!vis[k]){
                dfs(ar,k,vis,st);
            }
        }
        st.push(i);

    }
}
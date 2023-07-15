package tricky;
import java.util.*;
public class fillTheTank {

    long minimum_amount(int [][] edg, int n,int s,int[] cap){
        // Code here
        // we will use the dfs traversal and then find the answer using the nodes in the given tree
        // finding the capacity from the leafs will give the answer as the capacity of each tank is equal to max of values of leaf nodes * count of leaf nodes + cap[i]
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<=n;i++){
            ar.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edg.length;i++){
            int k=edg[i][0], k1=edg[i][1];
            ar.get(k).add(k1);
            ar.get(k1).add(k);
        }
        boolean[] vis=new boolean[n+1];
        long ans=dfs(ar,s,vis,cap);

        return ans;
    }

    long dfs(ArrayList<ArrayList<Integer>> ar,int i,boolean[] vis,int[] cap){
        vis[i]=true;
        int ct=0;
        long max=Long.MIN_VALUE;
        for(int k: ar.get(i)){
            if(!vis[k]){
                ct++;
                long val=dfs(ar,k,vis,cap);
                if(val==-1){
                    return -1;
                }
                max=Math.max(val,max);
            }
        }

        long val=max*ct+cap[i-1];
        if(val>(long)1e18){
            return -1;
        }
        return val;
    }
}

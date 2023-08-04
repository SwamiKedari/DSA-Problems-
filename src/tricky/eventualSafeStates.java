package tricky;
import java.util.*;
public class eventualSafeStates {
    HashSet<Integer> set=new HashSet<>();
    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        // Your code here
        // we will use the cycle detection algorithm to find the answer
        // all the nodes, which have cycle from them will be considered as not safe
        // we will do the dfs traversal from all the nodes, and we will store the status from the current array into the dp array
        // if this status is 1, that means there is a cycle starting from that point, else there is no cycle
        // this is to avoid wrong answer that we get after traversing subtree before the main tree
        // either we can use the dp array or modify the vis array and have different states for not visited, visited and cycle and visited and not cycle respectively
        
        boolean[] vis=new boolean[v+1];
        boolean[] pathvis=new boolean[v+1];
        int[] dp=new int[v+1];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                getans(i,vis,pathvis,adj,dp);
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!set.contains(i)){
                ar.add(i);
            }
        }

        return ar;
    }

    boolean getans(int i,boolean[] vis,boolean[] pathvis,List<List<Integer>> adj,int[] dp){
        if(pathvis[i]){
            set.add(i);
            dp[i]=1;
            return true;
        }

        if(dp[i]==1){
            return true;
        }
        else if(dp[i]==-1){
            return false;
        }
        if(!vis[i]){
            vis[i]=true ;
            pathvis[i]=true;
            boolean ans=false;
            for(int k: adj.get(i)){
                ans|=getans(k,vis,pathvis,adj,dp);
            }
            pathvis[i]=false;
            if(ans){
                set.add(i);
                dp[i]=1;
            }
            else{
                dp[i]=-1;
            }
            return ans;
        }
        dp[i]=-1;
        return false;
    }
}

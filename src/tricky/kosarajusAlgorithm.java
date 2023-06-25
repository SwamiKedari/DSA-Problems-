package tricky;
import java.util.*;
public class kosarajusAlgorithm {
    //Function to find number of strongly connected components in the graph.
    // first we will reverse the given graph to make sure that two different scc are not travelled during the single traversal
    // then we will do the topo sort on the given graph to know which vertice to start the dfs from
    // and from this vertices, we will do the dfs in the new reverse graph to know the number of components in the graph

    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<v;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=0;i<v;i++){
            ArrayList<Integer> ar=adj.get(i);
            for(int k: ar){
                a.get(k).add(i);
            }
        }

        // now we will find the components in the graph
        boolean[] vis=new boolean[v];
        int ans=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj,i,vis,st);
                st.push(i);
            }
        }
        vis=new boolean[v];
        while(!st.isEmpty()){
            int ind=st.pop();
            //System.out.println(ind);
            if(!vis[ind]){
                dfs(a,ind,vis);
                ans++;
            }
        }

        return ans;

    }

    public void dfs(ArrayList<ArrayList<Integer>> ar,int i,boolean[] vis,Stack<Integer> st){
        vis[i]=true;
        for(int k: ar.get(i)){
            if(!vis[k]){
                dfs(ar,k,vis,st);
                st.push(k);
            }
        }


    }

    public void dfs(ArrayList<ArrayList<Integer>> ar,int i,boolean[] vis){
        vis[i]=true;
        for(int k: ar.get(i)){
            if(!vis[k]){
                dfs(ar,k,vis);
            }
        }


    }
}

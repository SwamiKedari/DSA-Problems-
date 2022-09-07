import java.util.*;
public class motherVertexOfDirectedGraph {
    // doubt
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        // the code is based on the logic that if a vertex is true , than all the vertices which come next to it in dfs will also be true
        boolean[] visited=new boolean[v];
        int potent=-1;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,adj);
                potent=i;
            }
        }

        boolean[] vis=new boolean[v];
        dfs(potent,vis,adj);
        for(boolean k : vis){
            if(!k){
                return -1;
            }
        }
        return potent;
    }

    public void dfs(int i,boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[i]=true;
        for(int k : adj.get(i)){
            if(!visited[k]){
                dfs(k,visited,adj);
            }
        }
    }
}

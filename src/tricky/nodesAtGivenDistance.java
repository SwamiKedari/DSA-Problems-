package tricky;
import java.util.*;
public class nodesAtGivenDistance {
    int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n)
    {
        // Write your code here
        // we will just do the dfs and then find the nodes that are at the even distance will have the same colour
        // the nodes with the even distance will have the same color
        // thus we can find the total no of nodes using the n*(n-1)/2 value ie nc2
        int[] col=new int[2];
        boolean[] vis=new boolean[n+1];
        getans(graph,1,vis,col,0);
        int val1=col[0] , val2=col[1];
        return (val1*(val1-1))/2 + (val2*(val2-1))/2;
    }

    void getans(ArrayList<ArrayList<Integer>> graph,int i, boolean[] vis,int[] col,int dist){
        if(dist%2==1){
            col[0]++;
        }
        else{
            col[1]++;
        }
        vis[i]=true;
        for(int k: graph.get(i)){
            if(!vis[k]){
                getans(graph,k,vis,col,dist+1);
            }
        }
    }
}

package tricky;
import java.util.*;
public class hamiltonianPath {
    boolean check(int n,int m, ArrayList<ArrayList<Integer>> edg)
    {
        // code here
        // for the hamiltonian path, we will try all the paths from the particular vertice and then see if the no of elements in the set becomes equal to zero
        // if it becomes zero, then the hamiltonian path will exist, else it will not
        // we will back track and set the values to false after every traversal
        // this will help to get all the unique paths all the time
        
        HashSet<Integer> set=new HashSet<>();
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<=n;i++){
            ar.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edg.size();i++){
            int k=edg.get(i).get(0), k1=edg.get(i).get(1);
            ar.get(k).add(k1);
            ar.get(k1).add(k);
        }
        for(int i=1;i<=n;i++){
            set.add(i);

        }
        boolean[] vis=new boolean[n+1];
        // we will do the dfs and check whether all the edges are taken or not
        // if all the edges are taken in it
        boolean ans=false;
        for(int i=1;i<=n;i++){
            ans=dfs(ar,i,set,vis);
            if(ans){
                break;
            }
        }
        return ans;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> ar,int i,HashSet<Integer> set,boolean[] vis){
        vis[i]=true;
        set.remove(i);
        if(set.size()==0){
            vis[i]=true;
            set.add(i);
            return true;
        }
        boolean ans=false;
        for(int k: ar.get(i)){
            if(!vis[k]){
                ans|=dfs(ar,k,set,vis);
            }
        }
        vis[i]=false;
        set.add(i);
        return ans;
    }
}

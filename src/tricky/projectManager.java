package tricky;
import java.util.*; 
public class projectManager {
    public int minTime(ArrayList<pairForGraph> a, int[] d, int n, int m) {
        // code here
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<n;i++){
            ar.add(new ArrayList<>());
        }
        int[] ined=new int[n];
        for(int i=0;i<m;i++){
            int x=a.get(i).x, y=a.get(i).y;
            ar.get(x).add(y);
            ined[y]++;
        }
        // we will ue the topological sort to get the answer
        Queue<Integer> que=new LinkedList<Integer>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(i);
            if(ined[i]==0){
                que.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!que.isEmpty()){
            int val=que.remove();
            set.remove(val);
            topo.add(val);
            for(int k: ar.get(val)){
                ined[k]--;
                if(ined[k]==0){
                    que.add(k);
                }
            }
        }
        if(set.size()!=0){
            return -1;
        }
        boolean[] vis=new boolean[n];
        int[] dp=new int[n];
        int ans=Integer.MIN_VALUE;
        for(int k: topo){
            ans=Math.max(ans,getans(k,ar,vis,d,dp));
        }

        return ans;

    }


    public int getans(int i,ArrayList<ArrayList<Integer>> ar,boolean[] vis,int[] du,int[] dp){
        if(vis[i]){
            return dp[i];
        }
        vis[i]=true ;
        int ans=du[i];
        for(int k: ar.get(i)){
            ans=Math.max(getans(k,ar,vis,du,dp)+du[i],ans);
        }
        return dp[i]=ans;
    }
}

class pairForGraph{
    int x,y; 
    pairForGraph(int x,int y){
        this.x=x;this.y=y; 
    }
}
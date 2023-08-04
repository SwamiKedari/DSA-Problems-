package tricky;
import java.util.*;
public class wordLadderII
{

    HashSet<ArrayList<String>> ans=new HashSet<>();
    public ArrayList<ArrayList<String>> findSequences(String st, String t, String[] wl)
    {
        // Code here
        // we will use the hashset to store the distance and also the normal shortest distance in the undirected graph with unit weights to get the answwer


        int n=wl.length;

        String[] tot=new String[n+2];
        for(int i=1;i<=n;i++){
            tot[i]=wl[i-1];
        }
        tot[0]=st; tot[n+1]=t;
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<=n+1;i++){
            ar.add(new ArrayList<>());
        }
        n=tot.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edg(tot[i],tot[j])){
                    ar.get(i).add(j);
                    ar.get(j).add(i);
                }
            }
        }


        Queue<Integer> que=new LinkedList<>();
        que.add(0);
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        while(!que.isEmpty()){
            int k=que.remove();
            for(int u: ar.get(k)){
                if(dist[u]>dist[k]+1){
                    dist[u]=dist[k]+1;
                    que.add(u);
                }
            }
        }

        // after getting the dist, we can do the dfs and find the answer
        int distance=dist[n-1];
        boolean[] vis=new boolean[n];
        Stack<String> st1=new Stack<>();
        get(n-1,distance,dist,ar,vis,st1,tot);
        ArrayList<ArrayList<String>> ar1=new ArrayList<>();
        for(ArrayList<String> val: ans){
            ar1.add(val);
        }
        return ar1;
    }

    public void get(int i,int distance,int[] dist,ArrayList<ArrayList<Integer>> ar,boolean[] vis,Stack<String> st,String[] tot){
        if(i==0){

            ArrayList<String> tmp=new ArrayList<>();
            st.push(tot[i]);
            while(!st.isEmpty()){
                tmp.add(st.pop());
            }
            ans.add(tmp);
            for(int k=tmp.size()-1;k>-1;k--){
                st.push(tmp.get(k));
            }
            st.pop();
            // vis[i]=false;
            return;
        }
        vis[i]=true;
        st.push(tot[i]);
        for(int k: ar.get(i)){
            if(dist[k]==distance-1){
                get(k,distance-1,dist,ar,vis,st,tot);
            }
        }
        // vis[i]=false;
        st.pop();
    }

    public boolean edg(String a,String b){
        int n=a.length();
        int ct=0;
        for(int i=0;i<n;i++){
            if(a.charAt(i)!=b.charAt(i)){
                ct++;
            }
        }

        return ct==1;
    }
}


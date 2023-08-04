package tricky;
import java.util.*;
class pathWithMinEffort{

    int MinimumEffort(int h[][]) {
        // we will solve this problem using the djikstra's algorithm
        // when we consider the same path, we should take the max value in this path
        // when we consider the different paths, we should consider the min value in that paths
        // when taking the next node, we will consider the abs difference between the currnt node and the next node
        // if the max of this difference is lesser than the curr value of next node, then it will be updated, else it will be not updated
        // this will give us the answer
        PriorityQueue<tnode> que=new PriorityQueue<>(new Comparator<tnode>(){
            public int compare(tnode x,tnode y){
                if(x.dist<y.dist){
                    return -1;
                }
                else if(x.dist>y.dist){
                    return 1;
                }
                return 0;
            }
        });
        int n=h.length, m=h[0].length;
        que.add(new tnode(0,0,0));
        int[][] dist=new int[n][m];
        dist[0][0]=0;
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(!que.isEmpty()){
            tnode tnd=que.remove();
            int x=tnd.x, y=tnd.y, diff=tnd.dist;
            int[] xi={-1,0,1,0};
            int[] yi={0,-1,0,1};
            for(int i=0;i<xi.length;i++){
                if(isv(x+xi[i],y+yi[i],n,m)){
                    int k=Math.max(diff,Math.abs(h[x+xi[i]][y+yi[i]]-h[x][y]));
                    if(k<dist[x+xi[i]][y+yi[i]]){
                        dist[x+xi[i]][y+yi[i]]=k;
                        que.add(new tnode(x+xi[i],y+yi[i],dist[x+xi[i]][y+yi[i]]));
                    }
                }
            }
        }

        // after using the dijkstra's algorithm, we can get the answer in

        return dist[n-1][m-1];
    }

    boolean isv(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}

class tnode{
    int x,y, dist;
    public tnode(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
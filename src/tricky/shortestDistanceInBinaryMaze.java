package tricky;
import java.util.*;
class shortestDistanceInBinaryMaze {

    // we have to find the distance between the sc and the destination, we will use the similar logic to the knight walk problem
    // using the queue
    // using the dist array
    // using the graphnode object and putting it in the queue 
    int shortestPath(int[][] gd, int[] sc, int[] dst) {

        // Your code here
        // we have to find the shortest distance from the
        Queue<graphnode> que=new LinkedList<>();
        int n=gd.length, m=gd[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e8);
        }
        dist[sc[0]][sc[1]]=0;
        if(gd[sc[0]][sc[1]]==0){
            return -1;
        }
        que.add(new graphnode(sc[0],sc[1]));
        while(!que.isEmpty()){
            graphnode k=que.remove();
            int[] xi={-1,0,1,0};
            int[] yi={0,1,0,-1};
            int x=k.x, y=k.y;
            for(int i=0;i<4;i++){
                if(isbd(x+xi[i],y+yi[i],n,m) && gd[x+xi[i]][y+yi[i]]==1 && dist[x+xi[i]][y+yi[i]]>dist[x][y]+1){
                    dist[x+xi[i]][y+yi[i]]=dist[x][y]+1;
                    que.add(new graphnode(x+xi[i],y+yi[i]));
                }
            }

        }

        if(dist[dst[0]][dst[1]]==(int)1e8){
            return -1;
        }
        return dist[dst[0]][dst[1]];
    }
    boolean isbd(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}



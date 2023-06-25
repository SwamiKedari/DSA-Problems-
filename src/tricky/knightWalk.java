package tricky;
import java.util.*; 
class knightWalk
{
    public int minStepToReachTarget(int kp[], int tp[], int n)
    {
        // Code here
        // we have to find the shortest distance between the kp and the tp 
        // this type of logic can be used to solve any question related to the matrix and finding the shortest distance between the two points in the matrix 
        
        Queue<graphnode> que=new LinkedList<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e7);
        }
        dist[kp[0]-1][kp[1]-1]=0;
        int k1=kp[0]-1, k2=kp[1]-1;
        graphnode a=new graphnode(k1,k2);
        que.add(a);
        while(!que.isEmpty()){
            graphnode nd=que.remove();
            int[] xi={-1,1,-1,1,2,-2,2,-2};
            int[] yi={2,2,-2,-2,1,1,-1,-1};
            int x=nd.x, y=nd.y;
            for(int i=0;i<8;i++){
                if(isbd(x+xi[i],y+yi[i],n) && dist[x+xi[i]][y+yi[i]]>dist[x][y]+1){
                    dist[x+xi[i]][y+yi[i]]=dist[x][y]+1;
                    que.add(new graphnode(x+xi[i],y+yi[i]));
                }
            }


        }

        return dist[tp[0]-1][tp[1]-1];
    }

    public boolean isbd(int i,int j,int n){
        if(i>=0 && i<n && j>=0 && j<n){
            return true;
        }
        return false;
    }
}

class graphnode{
    int x, y;
    graphnode(int x,int y){
        this.x=x;
        this.y=y;
    }
}
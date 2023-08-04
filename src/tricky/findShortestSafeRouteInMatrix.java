package tricky;
import java.util.*; 
class findShortestSafeRouteInMatrix{
    public static int findShortestPath(int[][] a) {
        // code here
        // we can solve this problem using the algorithm similar to dp 
        int n=a.length, m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    if(isv(i-1,j,n,m,a)){
                        a[i-1][j]=-1;
                    }
                    if(isv(i,j-1,n,m,a)){
                        a[i][j-1]=-1;
                    }
                    if(isv(i+1,j,n,m,a)){
                        a[i+1][j]=-1;
                    }
                    if(isv(i,j+1,n,m,a)){
                        a[i][j+1]=-1;
                    }
                }
            }
        }

        int[][] dist=new int[n][m];
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(a[i])); 
        // }
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            if(a[i][0]==1){
                Queue<graphNode> que=new LinkedList<>();
                que.add(new graphNode(i,0));
                dist[i][0]=0;
                while(!que.isEmpty()){
                    graphNode k=que.remove();
                    int x=k.x, y=k.y;
                    if(isv(x+1,y,n,m,a) && dist[x+1][y]>dist[x][y]+1){
                        dist[x+1][y]=dist[x][y]+1;
                        que.add(new graphNode(x+1,y));
                    }
                    if(isv(x-1,y,n,m,a) && dist[x-1][y]>dist[x][y]+1){
                        dist[x-1][y]=dist[x][y]+1;
                        que.add(new graphNode(x-1,y));
                    }
                    if(isv(x,y-1,n,m,a) && dist[x][y-1]>dist[x][y]+1){
                        dist[x][y-1]=dist[x][y]+1;
                        que.add(new graphNode(x,y-1));
                    }
                    if(isv(x,y+1,n,m,a) && dist[x][y+1]>dist[x][y]+1){
                        dist[x][y+1]=dist[x][y]+1;
                        que.add(new graphNode(x,y+1));
                    }
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(dist[i])); 
        // }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dist[i][m-1]);
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans+1;
    }

    public static boolean isv(int i,int j,int n,int m,int[][] mat){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        if(mat[i][j]!=1){
            return false;
        }
        return true;
    }
    public static boolean isbd(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}

class graphNode{
    int x, y;
    public graphNode(int x,int y){
        this.x=x;
        this.y=y;
    }
}
        

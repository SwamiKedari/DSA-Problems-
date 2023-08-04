package tricky;
import java.util.*;
public class geekInAMaze{
    // we have to use bfs in this question as the dfs will not work in this case
    

    public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][])
    {
        // code here
        Queue<gnode> que=new LinkedList<>();
        que.add(new gnode(r,c,u,d));
        if(mat[r][c]=='#'){
            return 0;
        }
        mat[r][c]='#';
        int ct=1;
        while(!que.isEmpty()){
            gnode k=que.remove();
            //System.out.println(k.x+" "+k.y+" "+k.u+" "+k.d);
            //mat[k.x][k.y]='#';

            if(isbd(k.x,k.y+1,n,m) && mat[k.x][k.y+1]=='.'){
                mat[k.x][k.y+1]='#';
                ct++;
                que.add(new gnode(k.x,k.y+1,k.u,k.d));
            }
            if(isbd(k.x,k.y-1,n,m) && mat[k.x][k.y-1]=='.'){
                mat[k.x][k.y-1]='#';
                ct++;
                que.add(new gnode(k.x,k.y-1,k.u,k.d));
            }
            if(isbd(k.x-1,k.y,n,m) && k.u>0 && mat[k.x-1][k.y]=='.'){
                mat[k.x-1][k.y]='#';
                ct++;
                que.add(new gnode(k.x-1,k.y,k.u-1,k.d));
            }
            if(isbd(k.x+1,k.y,n,m) && k.d>0 && mat[k.x+1][k.y]=='.'){
                mat[k.x+1][k.y]='#';
                ct++;
                que.add(new gnode(k.x+1,k.y,k.u,k.d-1));
            }

        }

        return ct;

    }

    public static boolean isbd(int x,int y,int n,int m){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }

}

class gnode{
    int x,y,u,d;
    public gnode(int x,int y,int u,int d){
        this.x=x;
        this.y=y;
        this.u=u;
        this.d=d;
    }
}
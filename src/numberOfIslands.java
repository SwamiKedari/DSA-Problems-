import java.util.*;
public class numberOfIslands {
    // Function to find the number of islands.
    // this is a dfs based algorithm which completes one island in one dfs loop , it also contains the diagonal wise condition mentioned in the question
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        return count;
    }


    public void dfs(int i,int j,int n,int m,char[][] grid){
        grid[i][j]='0';
        if(isValid(i-1,j,n,m) && grid[i-1][j]=='1'){
            dfs(i-1,j,n,m,grid);
        }
        if(isValid(i+1,j,n,m) && grid[i+1][j]=='1'){
            dfs(i+1,j,n,m,grid);
        }
        if(isValid(i,j-1,n,m) && grid[i][j-1]=='1'){
            dfs(i,j-1,n,m,grid);
        }
        if(isValid(i,j+1,n,m) && grid[i][j+1]=='1'){
            dfs(i,j+1,n,m,grid);
        }
        if(isValid(i-1,j-1,n,m) && grid[i-1][j-1]=='1'){
            dfs(i-1,j-1,n,m,grid);
        }
        if(isValid(i+1,j+1,n,m) && grid[i+1][j+1]=='1'){
            dfs(i+1,j+1,n,m,grid);
        }
        if(isValid(i-1,j+1,n,m) && grid[i-1][j+1]=='1'){
            dfs(i-1,j+1,n,m,grid);
        }
        if(isValid(i+1,j-1,n,m) && grid[i+1][j-1]=='1'){
            dfs(i+1,j-1,n,m,grid);
        }

    }

    public boolean isValid(int i,int j,int n,int m){
        if(i<n && i>-1 && j<m && j>-1){
            return true;
        }
        return false;
    }
}

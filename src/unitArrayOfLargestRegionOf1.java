public class unitArrayOfLargestRegionOf1 {

    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[] a=new int[1];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i,j,n,m,a,grid);
                    // System.out.println(a);
                    max=Math.max(max,a[0]);
                    a[0]=0;
                }
            }
        }
        // one of the region of the rectangles will sink everytime the dfs occurs



        return max;

    }

    public void dfs(int i,int j,int n,int m, int[] a,int[][] grid){
        grid[i][j]=0;
        a[0]++;
        if(isValid(i-1,j,n,m ) && grid[i-1][j]==1){
            dfs(i-1,j,n,m,a,grid);
        }
        if(isValid(i+1,j,n,m ) && grid[i+1][j]==1){
            dfs(i+1,j,n,m,a,grid);
        }
        if(isValid(i,j-1,n,m ) && grid[i][j-1]==1){
            dfs(i,j-1,n,m,a,grid);
        }
        if(isValid(i,j+1,n,m ) && grid[i][j+1]==1){
            dfs(i,j+1,n,m,a,grid);
        }
        if(isValid(i-1,j-1,n,m ) && grid[i-1][j-1]==1){
            dfs(i-1,j-1,n,m,a,grid);
        }
        if(isValid(i+1,j+1,n,m ) && grid[i+1][j+1]==1){
            dfs(i+1,j+1,n,m,a,grid);
        }
        if(isValid(i-1,j+1,n,m ) && grid[i-1][j+1]==1){
            dfs(i-1,j+1,n,m,a,grid);
        }
        if(isValid(i+1,j-1,n,m ) && grid[i+1][j-1]==1){
            dfs(i+1,j-1,n,m,a,grid);
        }
    }

    public boolean isValid(int i,int j,int n,int m){
        if(i>-1 && i<n && j>-1 && j<m){
            return true;
        }
        return false;
    }
}

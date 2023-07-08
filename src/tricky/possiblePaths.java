package tricky;

public class possiblePaths {
    // we have to find whether it is possible to come to the given point again after traversing the all the edges and paths
    // we need to traverse the paths exactly once
    // this is the condition for the euler's circuit
    // we can find the answer by checking the no of edges in the graph for each node
    // this values must be even else it is not the euler's circuit
    public int isPossible(int[][] paths)
    {
        // Code here
        int ans=1;
        int n=paths.length, m=paths[0].length;
        for(int i=0;i<n;i++){
            int ct=0;
            for(int j=0;j<m;j++){
                if(paths[i][j]==1){
                    ct++;
                }
            }
            if(ct%2==1){
                ans=0;
                break;
            }
        }

        return ans;
    }
}

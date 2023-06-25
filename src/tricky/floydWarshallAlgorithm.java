package tricky;

public class floydWarshallAlgorithm {
    // floydWarshall algorithm is the brute force algorithm to find the shortest distance in the weighted graph between the any two nodes
    // the distance between teh node a and b is represented by dist[a][b] where dist is the answer of the  floydwarshall algorithm
    // algorithm involves 3 for loops where the outer loop is the via loop, and the inner two loops are the loops from the i, and j
    // the logic used is that the dist[i][j]=min(dist[i][via]+dist[via][j],dist[i][j])
    // this will give the answer in o(n3) time complexity and o(n2) space complexity
    public void shortest_distance(int[][] mat)
    {
        // Code here
        int n=mat.length;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    dist[i][j]=(int)1e7;
                }
                else{
                    dist[i][j]=mat[i][j];
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(dist[i]));
        // }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //System.out.println(dist[i][j]+" "+dist[i][via]+" "+dist[via][j]);
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    //System.out.println(dist[i][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]>=(int)1e7){
                    mat[i][j]=-1;
                }
                else{
                    mat[i][j]=dist[i][j];
                }
            }
        }
    }
}

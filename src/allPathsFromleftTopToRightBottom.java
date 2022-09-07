public class allPathsFromleftTopToRightBottom {
    long numberOfPaths(int m, int n) {
        // Code Here
        // this code gives all the paths from left top to right bottom
        // this is the recursive method for the code , which returns the total paths from left to right of the matrix

        if(m==1 || n==1){
            return 1;

        }
        return numberOfPaths(m-1,n)+numberOfPaths(m,n-1);
    }
}

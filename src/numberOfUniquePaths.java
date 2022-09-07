public class numberOfUniquePaths {
    // this problem gives the total number of unique paths to reach the bottom right from the top left
    // this is a recursive approach
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b)
    {
        //Your code here
        // we need to find the total paths from the upper left to the bottom right

        // int n=NumberOfPath(a-1,b);
        // int n1=NumberOfPath(a,b-1);
        if(a==1){
            return 1;
        }
        if(b==1){
            return 1;
        }

        int n=NumberOfPath(a-1,b);
        int n1=NumberOfPath(a,b-1);

        return n+n1;

    }
}

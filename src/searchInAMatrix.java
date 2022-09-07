public class searchInAMatrix {
    // we have to search for a element in the matrix which is sorted in any row and in any column
    // time complexity =O(n+m)
    // space complexity =O(1)

    public static int matSearch(int[][] ma,int n,int m,int x)
    {
        // your code here
        // start from the upper right corner , if the val of x is greater than this value , we will travel down side , else we will travel left side
        int k=ma[0][m-1];
        int i=0 ,j=m-1;
        if(k==x){
            return 1;
        }
        while(k!=x && i>-1 && i<n && j>-1 && j<m){
            k=ma[i][j];
            if(k==x){
                return 1;
            }
            else if(x>k){
                i++;
            }
            else{
                j--;
            }

        }
        return 0;

    }
}

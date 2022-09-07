public class IndexOfExtraElement {
    //class to find the index of the extra elements of the 2 array in o(logn) time
    // doubt
    public int findExtra(int ar[], int br[], int n) {
        // add code here.
        int index=n;
        int i=0, j=n-1;
        int[] a,b;
        if(ar[ar.length-1]!=br[br.length-1]){
            return Math.max(ar.length,br.length)-1;
        }
        if(ar.length>br.length){
            a=ar;
            b=br;
        }
        else{
            a=br;
            b=ar;
        }
        while(i<j){
            int mid=(i+j)/2;
            if(a[mid]==b[mid]){
                i++;
            }
            else{
                index=mid;
                j--;
            }
        }
        return index;
    }
}

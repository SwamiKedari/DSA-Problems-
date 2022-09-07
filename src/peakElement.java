public class peakElement {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] a,int n)
    {
        //add code here.
        if(n==1){
            return 0;
        }
        if(a[0]>a[1]){
            return 0;
        }
        if(a[n-1]>a[n-2]){
            return n-1;
        }

        return peakBinary(a,0,n-1);
    }
    public int peakBinary(int[] a,int i,int j){
        if(i>j){
            return -1;
        }
        int mid=(i+j)/2;
        if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){
            return mid;
        }
        else if(a[mid]<a[mid+1]){
            return peakBinary(a,mid+1,j);
        }
        else {
            return peakBinary(a,0,mid-1);
        }
        //return -1;
    }
}

public class countInversions {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        // use merge sort algorithm , when the two nodes swap , then u need to increase the count of count inversion
        // this will give the answer
        int h=(int)N;
        long[] a=new long[1];
        mergeSort(arr,0,arr.length-1,a);
        //System.out.println(Arrays.toString(arr));
        return a[0];

    }

    static void mergeSort(long[] arr, int l,int r,long[] a){
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(arr,l,mid,a);
            mergeSort(arr,mid+1,r,a);
            merge(arr,l,mid,r,a);
        }
    }

    static void merge(long[] c,int l,int mid,int r,long[] inv){
        long[] a=new long[mid-l+1];
        long[] b=new long[r-mid];
        for(int i=0;i<mid-l+1;i++){
            a[i]=c[i+l];
        }
        for(int i=0;i<r-mid;i++){
            b[i]=c[mid+1+i];
        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));

        int n1=a.length , n2=b.length;
        int i=0 , j=0 ,k=l;
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
                k++;
            }
            else {
                inv[0]+=n1-i; // the magic of getting the inversion count happens over here
                //System.out.println(a[i]+" "+b[j]);
                c[k]=b[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<n2){
            c[k]=b[j];
            j++;
            k++;
        }



    }
}

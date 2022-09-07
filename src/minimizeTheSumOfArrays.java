public class minimizeTheSumOfArrays {
    // https://practice.geeksforgeeks.org/problems/minimize-the-sum-of-product1525/1/?page=1&curated[]=1&sortBy=submissions#
    public long minValue(long a[], long b[], long n)
    {
        // doubt
        // Your code goes here
        // we need to sort the first array
        // and we need to sort the second array in reverse array
        // lets make quicksort
        int n1=(int)n;
        quickSort(a,0,n1-1);
        quickSort1(b,0,n1-1);
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        long sum=0;
        for(int i=0;i<n1;i++){
            sum+=a[i]*b[i];
        }
        return sum;

    }

    public void quickSort(long[] a,int l,int r){
        if(l<r){
            int pivot=partition(a,l,r);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,r);
        }
    }
    public void quickSort1(long[] a,int l,int r){
        if(l<r){
            int pivot=partition1(a,l,r);
            quickSort1(a,l,pivot-1);
            quickSort1(a,pivot+1,r);
        }
    }

    public int partition(long[] a,int l,int r){
        int i=l-1;
        int p=r;
        for(int j=l;j<r;j++){
            if(a[j]<a[p]){
                i++;
                swap(a,i,j);

            }
        }
        swap(a,i+1,p);
        return i+1;

    }
    public int partition1(long[] a,int l,int r){
        int i=l-1;
        int p=r;
        for(int j=l;j<r;j++){
            if(a[j]>a[p]){
                i++;
                swap(a,i,j);

            }
        }
        swap(a,i+1,p);
        return i+1;

    }

    public void swap(long[] a,int i,int j){
        long k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
}

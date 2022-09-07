public class findingIndexOfRotatedSortedArray {
    //this is the method to get the index of the rotated and sorted , this question was to be solved in O(n) time complexity
    public int search(int[] n, int t) {
        int k=n.length;
        int i=0;
        int j=k-1;

        if(n.length==1){
            if(t==n[0]){
                return 0;
            }
            else{
                return -1;
            }
        }
        if(n.length==2){
            if(t==n[0]){
                return 0;
            }
            else if(t==n[1]){
                return 1;
            }
            else{
                return -1;
            }
        }
        if(n[0]<n[j]){
            return binarySearch(n,t,i,j);
        }
        int piv=0;
        if(n[j]<n[j-1]){
            piv=j;
        }
        else{
            for(int p=j-1;p>=0;p--){
                if(n[p]<n[p+1]&&n[p]<n[p-1]){
                    piv=p;
                    break;
                }
            }}
        System.out.println(piv);
        if(t>=n[0]){
            return binarySearch(n,t,0,piv-1);
        }
        else{
            return binarySearch(n,t,piv,j);

        }
    }




    public int binarySearch(int[] a,int n,int i,int j){
        if(i>j){
            return -1;
        }
        else{
            int k=(i+j)/2;
            if(a[k]==n){
                return k;
            }
            else if(a[k]<n){
                return binarySearch(a,n,k+1,j);
            }
            else{
                return binarySearch(a,n,i,k-1);
            }
        }
    }
}

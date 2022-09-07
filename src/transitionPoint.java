public class transitionPoint {
    //in this question we used the binarysearch algorithm to find the transition point in the array of 0 and 1
    int transitionPoint(int a[], int n) {
        // code here
        if(n==1&&a[n-1]==1){
            return 0;
        }
        return binarySearch(a,0,n-1);

    }
    int binarySearch(int[] a,int i,int j){
        if(i>j){
            return -1;
        }


        int mid=(i+j)/2;


        if(a[mid]==1&&mid>0&&a[mid-1]==0){
            return mid;
        }
        else if(a[mid]==1){
            if(mid==i){
                return 0;
            }
            return binarySearch(a,i,mid-1);
        }

        return binarySearch(a,mid+1,j);

        // return -1;
    }
}

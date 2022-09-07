public class smallestSubarrayWithSumGreaterThanx {
    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here
        // this problem is similar to the subarray with given sum problem
        // we will keep a count variable which will contain the length of the subarray
        int sum=0;
        int l=0;
        int r=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=a[i];
            boolean isloop=false;
            while(sum>x){
                sum-=a[l];
                // System.out.println(l);
                isloop=true;
                l++;
            }
            if(isloop){
                l--;
                sum+=a[l];
                min=Math.min(min,i-l+1);
            }



        }

        return min ;

    }
}

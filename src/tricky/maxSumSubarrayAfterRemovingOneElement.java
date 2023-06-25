package tricky;

public class maxSumSubarrayAfterRemovingOneElement {
    //Function to return maximum sum subarray by removing at most one element.
    // we will take the sum from the front and the sum from the back and then take the max of the additions of both of this
    
    public static int maxSumSubarray(int[] a,int n)
    {
        // add code here.
        // variation of the kadane's algorithm
        int[] pre=new int[n];
        int[] suf=new int[n];
        int sum=0, maxval=Integer.MIN_VALUE;
        int ct=0, minval=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum<0){
                sum=0;
            }
            pre[i]=sum;
            maxval=Math.max(maxval,sum);
            if(a[i]<0){
                ct++;
                minval=Math.max(minval,a[i]);
            }
        }

        if(ct==n){
            return minval;
        }

        sum=0;
        for(int i=n-1;i>-1;i--){
            sum+=a[i];

            suf[i]=sum;
            if(sum<0){
                sum=0;
            }
        }
        //System.out.println(Arrays.toString(pre));
        //System.out.println(Arrays.toString(suf));
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            max=Math.max(pre[i]+suf[i+1]-a[i+1], max);
        }

        return Math.max(max,maxval);

    }
}

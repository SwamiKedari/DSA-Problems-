package tricky;

public class largestSumSubarrayOfSizeAtleastK {

    public long maxSumWithK(long a[], long n, long k1)
    {
        // we have to find the largest sum subarray containing alteast k numbers
        // we can solve this problem by storing the kadane's output from the end
        // the stored kd array contains the positive subarray sum from the end to that point in the array
        // this stored kd array will help us to find the ans by using the sliding window of size k
        // at each point, the answer will be max sum of the subarray with size greater than or equal to k
        int m=(int)n;
        int k=(int)k1;
        long[] kd=new long[m];
        long sum=0;
        for(int i=m-1;i>-1;i--){
            sum+=a[i];
            if(sum<0){
                sum=0;
            }
            kd[i]=sum;
        }
        //System.out.println(Arrays.toString(kd));
        sum=0;
        for(int i=0;i<k;i++){
            sum+=a[i];
        }
        long ans=Integer.MIN_VALUE;
        if(k<m){
            ans=Math.max(sum+kd[k],ans);
        }
        else{
            ans=Math.max(sum,ans);
        }
        // System.out.println(ans);
        int l=0;
        for(int i=k;i<m;i++){
            sum-=a[l];
            sum+=a[i];
            if(i+1<m){

                ans=Math.max(ans,sum+kd[i+1]);
            }
            else{
                ans=Math.max(ans,sum);
            }
            l++;
            //System.out.println(ans);
        }
        return ans;
    }
}

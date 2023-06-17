package tricky;

public class countTheSubarraysWithProductLessThanK {
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        // we are given the array of positive integers, we are asked to subarrays which has the product less than the number k
        // this question can be solved using the sliding window problem
        // the no of the subarrays formed by a single number will be equal to the total different start points of the subarray to that number
        // this will give the answer for the question 
        long pr=1;
        int l=0;
        long ans=0;
        for(int i=0;i<n;i++){
            if(pr*a[i]>=k){
                while(l<=i && pr*a[i]>=k){
                    pr/=a[l];
                    l++;
                }
                if(pr==0){
                    pr=1;
                }
            }
            //System.out.println(l+" "+i+" "+pr);
            if(l<=i){
                ans+=(i-l+1);
                pr*=a[i];
            }
        }

        return ans;



    }
}

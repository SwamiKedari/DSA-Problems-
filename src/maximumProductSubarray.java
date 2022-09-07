public class maximumProductSubarray {
    class Solution {
        // Function to find maximum product subarray
        // // doubt
        long maxProduct(int[] a, int n) {
            // code here
            long mul=a[0];
            long mul1=a[n-1];
            long cur=1;
            long cur1=1;
            for(int i=0;i<n;i++){
                cur*=a[i];
                cur1*=a[n-i-1];
                if(cur>mul){
                    mul=cur;
                }
                if(cur==0){
                    cur=1;
                }
                if(cur1>mul1){
                    mul1=cur1;
                }
                if(cur1==0){
                    cur1=1;
                }

            }

            return Math.max(mul,mul1);

        }
    }
}

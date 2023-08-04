package tricky;

public class pyramidForm {
    static int pyramidForm(int[] a,int n) {
        // code here
        // we are given the array a of n stones, we are asked to make the pyramid out of it
        // we have to do this in o(n)
        // we have to find the length of the max pyramid , the answer will be total sum - the sum of pyramid
        // we should use dp to decide the max len of a particular index depending upon its adjacent indexes
        // also this answer will be min answer as the sum of the pyramid is max in this case
        int[] dp=new int[n];
        dp[0]=1;
        int[] dp1=new int[n];
        dp1[n-1]=1;
        for(int i=1;i<n;i++){
            if(a[i]>dp[i-1]){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=a[i];
            }
        }

        for(int i=n-2;i>-1;i--){
            if(a[i]>dp1[i+1]){
                dp1[i]=dp1[i+1]+1;
            }
            else{
                dp1[i]=a[i];
            }
        }
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            int val=Math.min(dp[i],dp1[i]);
            max=Math.max(val,max);
            sum+=a[i];
        }
        return sum-(max*(max+1)/2)-(max*(max-1)/2);


    }
}

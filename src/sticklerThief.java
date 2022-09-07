public class sticklerThief {
    //Function to find the maximum money the thief can get.
    // thief can not steal the stuff from adjacent houses
    // money in the house is represented in the array a
    public int FindMaxSum(int a[], int n)
    {
        // Your code here
        // this problem is similar to the max sum with no elements adjacent to one another
        int[] dp=new int[n];
        return getMax(a,dp,n-1,n);

    }
    public int getMax(int[] a,int[] dp,int i,int n){
        if(i==0){
            dp[0]=a[0];
            return a[0];
        }
        if(i<0){

            return 0;
        }
        if(dp[i]>0){
            return dp[i];
        }
        int n1=getMax(a,dp,i-2,n)+a[i];
        int n2=getMax(a,dp,i-1,n)+0;
        dp[i]=Math.max(n1,n2);
        return dp[i];
    }
}

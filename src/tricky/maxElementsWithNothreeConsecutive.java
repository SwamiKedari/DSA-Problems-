package tricky;

public class maxElementsWithNothreeConsecutive {
    // the following logic can be applied to take the elements such that the 3 elements are not taken in the consecutive element
    // this will give the max answer in the array
    public int maxCalories(int a[], int n)
    {
        // Your code goes here
        int[][] dp=new int[n][3];
        return getans(a,0,0,n,dp);
    }

    public int getans(int[] a,int i,int j,int n,int[][] dp){
        if(i==n){
            return 0;
        }
        int val=Integer.MIN_VALUE;
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(j==2){
            val=getans(a,i+1,0,n,dp);
        }
        else if(j==1){
            val=Math.max(getans(a,i+1,j+1,n,dp)+a[i],getans(a,i+1,0,n,dp));
        }
        else if(j==0){
            val=Math.max(getans(a,i+1,j+1,n,dp)+a[i],getans(a,i+1,0,n,dp));
        }
        dp[i][j]=val;
        return dp[i][j];
    }
}

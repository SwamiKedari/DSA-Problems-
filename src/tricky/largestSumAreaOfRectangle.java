package tricky;

public class largestSumAreaOfRectangle {
    // in this question, we are asked to find the area of the rectangular submatrix which has the maximum value in the rectangle
    int maximumSumRectangle(int r,int c,int[][] m) {
        // code here
        int ans=Integer.MIN_VALUE;
        for(int j=0;j<c;j++){
            int[] val=new int[r];

            for(int k=j;k<c;k++){
                for(int i=0;i<r;i++){
                    val[i]+=m[i][k];
                }
                ans=Math.max(ans,kadane(val));
            }
        }

        return ans;

    }

    int kadane(int[] a){
        int n=a.length;
        int sum=Integer.MIN_VALUE;
        int cur=0;
        for(int i=0;i<n;i++){
            cur+=a[i];
            sum=Math.max(cur,sum);
            if(cur<0){
                cur=0;
            }

        }

        return sum;
    }
}

package tricky;
import java.util.*;
public class sumOfTwoElementsWithSumClosestToZero {
    public static int closestToZero (int a[], int n)
    {
        // your code here
        Arrays.sort(a);
        int l=0, r=n-1;
        int max=Integer.MAX_VALUE;
        while(l<r){
            int val=a[l]+a[r];
            if(Math.abs(val)<Math.abs(max)){
                max=val;
            }
            else if(Math.abs(val)==Math.abs(max)){
                if(max<val){
                    max=val;
                }
            }
            if(val<0){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
    }
}

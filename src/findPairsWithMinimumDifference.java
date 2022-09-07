import java.util.*;

public class findPairsWithMinimumDifference {
    long findMinSum(int[] a,int[] b,int n) {
        // when the array elements are in sorted order than the absoluted difference between the pairs is minimum
        // in this question , we have to find the minimum of the absolute differences between the pairs of the array elements
        // this can be achieved if we sort both arrays and then find the difference
        // this is a problem of greedy type
        Arrays.sort(a);
        Arrays.sort(b);
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.abs(a[i]-b[i]);
        }
        return sum;
    }
}

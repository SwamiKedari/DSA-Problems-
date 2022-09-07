import java.util.*;
//java function to find the numbers of subarrays with sum equal to zero in O(n) time complexity
/*is method is based on the fact that the sum from starting is repeated as atleast one of the if the sum of the subarray from that
subarray to the given element of the array */
public class findingSubArraysWithZeroSum {
    // no clear description
    public static long findSubarray(long[] a ,int n)
    {
        //Your code here
        HashMap<Long,Long> m=new HashMap<>();
        long k=0;
        int i=0;
        long sum=0;
        m.put((long)0,(long)1);

        while(i<n){
            sum+=a[i];
            if(m.containsKey(sum)){
                k+=m.get(sum);
                m.put(sum,m.get(sum)+1);
            }
            else{
                m.put(sum,(long)1);
            }
            i++;
        }
        return k;
    }
}

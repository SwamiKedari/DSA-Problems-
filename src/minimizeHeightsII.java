import java.util.Arrays;

public class minimizeHeightsII {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        // doubt
        /* the minimum difference occurs when either the smallest is first element + k and largest is last-k
        but this is not the case always , sometimes some middle element + k can take the largest and its difference with the smallest can be minimum
        also sometimes some middle element - k can be the smallest and its difference with the largest can be minimum
        we dont consider all the permutations , because all the cases of the minimum will be adjacent to each other if both of them can satisfy the role of maximum and the minimum element

        */
        Arrays.sort(arr);
        int min=arr[n-1]-arr[0];
        int smallest=arr[0]+k;
        int largest=arr[n-1]-k;
        int min1=0 , max1=0;
        for(int i=0;i<n-1;i++){
            min1=Math.min(smallest,arr[i+1]-k);
            max1=Math.max(largest,arr[i]+k);
            if(min1<0){
                continue;
            }
            if(max1-min1<min){
                min=max1-min1;
            }
        }

        return min;
    }
}

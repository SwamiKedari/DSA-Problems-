package tricky;
import java.util.*;
public class tripletWithZeroSum {
    // for finding the triplet with zero sum and using constant extra space, we use the two pointer approach,
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int a[] , int n)
    {
        //add code here.
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            int l=i+1, r=n-1;
            int val=a[i];
            // for each i, we find use the two pointers, one in the front and one in the last
            // if the value of a[i]+a[l]+a[r] is greater than zero, we decrease r
            // if it is less than zero, we increase l
            // if we find the value equal to zero , we will return true
            // else we will return false;
            while(l<r){
                int k=a[l]+a[r];
                if(val+k>0){
                    r--;
                }
                else if(val+k<0){
                    l++;
                }
                else{
                    return true;
                }
            }
        }

        return false;
    }
}

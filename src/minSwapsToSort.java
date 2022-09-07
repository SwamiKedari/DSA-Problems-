
import java.util.*;
public class minSwapsToSort {
    // doubt
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        // we create a hashmap to store the array elements along with their original index
        // then we will use this hashmap to compare the element values with their indexes in the original array and will swap them until their values are not equal in the original sorted array
        HashMap<Integer,Integer> a=new HashMap<>();
        int[] b=new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            b[i]=nums[i];
        }

        Arrays.sort(b);
        int count=0;

        for(int i=0;i<n;i++){
            a.put(b[i],i);
        }

        for(int i=0;i<n;i++){
            while(a.get(nums[i])!=i){
                count++;
                swap(nums,i,a.get(nums[i]));
            }
        }

        return count;
    }


    public void swap(int[] n,int i,int j){
        int temp=n[i];
        n[i]=n[j];
        n[j]=temp;




    }
}

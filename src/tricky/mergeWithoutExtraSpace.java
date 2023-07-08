package tricky;
import java.util.*;
public class mergeWithoutExtraSpace {
    //Function to merge the arrays.
    public static void merge(long a1[], long a2[], int n, int m)
    {
        // code here
        // this question can be solved using the three pointers, i,j and k
        // if a1[i]<a2[j], we will increase i
        // if a1[i]>a2[j], a2[j] will belong to the first array, so we swap a1[k] and a2[j] and decrease k and increase j
        // we continue doing this till i<=k 
        int i=0 ,k=n-1, j=0;
        while(i<=k && j<m){
            if(a1[i]<=a2[j]){
                i++;
                //j++;
            }
            else{
                swap(a1,a2,k,j);
                k--;
                j++;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
    }


    public static void swap(long[] a,long[] b,int i,int j){
        long temp=a[i];
        a[i]=b[j];
        b[j]=temp;
    }
}

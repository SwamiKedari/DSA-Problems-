import java.util.*;
//problem is to check if the pair exists with given difference
//the time complexity required is O(nlog(n))
//space complexity is O(1)
//the main logic is to sort the array with O(nlogn) and then apply the binarySearch for each element to check if the other element to get such a difference exists or not
//the time complexity turns out to be 2n*logn which is indirectly nlogn
public class findPairWithGivenDifference {
    public boolean findPair(int a[], int s, int n)
    {
        //code here.
        Arrays.sort(a);
        for(int i=0;i<s;i++){
            int r=n+a[i];//finding the element with n+a[i] value so that difference with that element is equal to n
            if(binarySearch(a,i,s-1,r)!=-1){
                return true;
            }
        }
        return false;

    }
    public int binarySearch(int[] a,int i,int j,int k){
        if(i>j){
            return -1;
        }
        else{
            int u=(i+j)/2;
            if(a[u]==k){
                return u;
            }
            else if(a[u]>k){
                return binarySearch(a,i,u-1,k);
            }
            else{
                return binarySearch(a,u+1,j,k);
            }
        }
    }
}

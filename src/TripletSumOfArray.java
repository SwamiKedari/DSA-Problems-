import java.util.*;
public class TripletSumOfArray {


        //Function to find if there exists a triplet in the
        //array A[] which sums up to X.
        public static boolean find3Numbers(int a[], int n, int x) {

            Arrays.sort(a);
            for(int i=0;i<n;i++){
                if(x-a[i]>0&&find2Numbers(a,n,x-a[i],i)){
                    //System.out.println(a[i]);
                    return true;
                }
            }
            return false;
        }
        public static boolean find2Numbers(int[] a,int n,int x,int i){
            int h=0;
            int k=n-1;
            int ans=a[0]+a[n-1];

            while(h<k){
                if(ans<x){
                    h++;
                }
                else if(ans==x&&h!=i&&k!=i){
                    return true;
                }
                else{
                    k--;
                }
                ans=a[h]+a[k];

            }
            return false;
        }
    }



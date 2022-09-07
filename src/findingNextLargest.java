import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findingNextLargest {
    static List<Integer> nextPermutation(int n, int a[]){
        // code here
        // doubt
        List<Integer> b=new ArrayList<Integer>();
        int k=-1;
        for(int i=n-2;i>-1;i--){
            if(a[i]<a[i+1]){
                k=i;
                break;
            }
        }
        if(k==-1){
            Arrays.sort(a);
            for(int i=0;i<n;i++){
                b.add(a[i]);
            }
            return b;
        }

        int l=0;
        for(int i=n-1;i>k;i--){
            if(a[i]>a[k]){
                l=i;
                break;
            }
        }
        int g=a[k];
        a[k]=a[l];
        a[l]=g;

        rev(a,k+1,n-1);
        for(int i=0;i<n;i++){
            b.add(a[i]);
        }
        //System.out.println(k+" "+l);
        return b;

    }
    private static void  rev(int[] a,int k,int n){
        int h=(n+k)/2;
        for(int i=k;i<=h;i++){
            int b=a[i];
            a[i]=a[n];
            a[n]=b;
            n--;
        }
    }
}

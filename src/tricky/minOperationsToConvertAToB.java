package tricky;
import java.util.*;
public class minOperationsToConvertAToB {
    static int minInsAndDel(int[] a,int[] b,int n,int m) {
        // code here
        // we are asked to find the min no of insertions and deletions on the array a
        // no of operations will be equal to total elements in both arrays - lcs
        // we have to find the lcs using lis type of algorithm since the second array is already sorted
        // we will check whether the element in a is present in b, if it is present and it can be fitted into the lis of a, we will fit it
        // this lis will be lcs of both the arrays a and b , thus we will find the answer using this both arrays

        HashSet<Integer> set=new HashSet<>();
        for(int k: b){
            set.add(k);
        }
        TreeSet<Integer> tset=new TreeSet<>();
        for(int i=0;i<n;i++){
            int val=a[i];
            if(set.contains(val)){
                if(tset.size()==0){
                    tset.add(val);
                }
                else if(tset.last()<val){
                    tset.add(val);
                }
                else{
                    Integer k1=tset.ceiling(val);
                    if(k1!=null){
                        tset.remove(k1);
                        tset.add(val);
                    }
                }
            }
        }

        return n+m-2*tset.size();
    }
}

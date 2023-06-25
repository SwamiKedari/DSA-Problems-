package tricky;
import java.util.* ;
public class LIS {
    public int removeStudents(int[] h, int n) {
        ArrayList<Integer> ar=new ArrayList<Integer>();
        // in the arraylist , it gives the -insertionpoint -1
        ar.add(h[0]);

        for(int k: h){
            int ind=Collections.binarySearch(ar,k);
            if(k>ar.get(ar.size()-1)){
                ar.add(k);
                continue;
            }
            if(ind==-1){
                ar.set(ind+1,k);
            }
            else if(ind>=0){
                continue;
            }
            else{
                ind=-1*ind-1;
                ar.set(ind,k);
            }
        }
        //System.out.println(String.valueOf(ar));

        return n-ar.size();

    }
// the two methods include the lis using the arraylist and using the treeset
    // in the arraylist, we do the binarysearch and then find the answer
    // collections.binarysearch returns the index of teh value in the list if the element is present, else it returns the value -ind-1 where ind is the insertion point in the list


    public int removeStudents1(int[] h,int n) {
        // code here
        // this is the lis problem
        // we need to implement the list algorithm in the nlogn to get the answer
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            Integer k=set.ceiling(h[i]);
            if(k==null){
                set.add(h[i]);

            }
            else{
                set.remove(k);
                set.add(h[i]);
            }
        }
        //System.out.println(String.valueOf(set));
        return n-set.size();
    }
}

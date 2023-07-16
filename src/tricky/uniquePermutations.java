package tricky;
import java.util.*;
public class uniquePermutations {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> a , int n) {
        // code here
        // we have to find the no of unique permutations of the array
        // we can solve this problem using the recursion, storing each element in the array and removing it after insertion
        // we will use the custom comparator to sort the array presnt in this problem where we will compare all the elements in the list and return -1 or 1 depending on the order

        boolean[] tk=new boolean[n];
        Collections.sort(a);
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        f(set,a,new ArrayList<Integer>(), tk,0,n);
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(ArrayList<Integer> val: set){
            ar.add(val);
        }

        Collections.sort(ar,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                int len=a.size();
                for(int i=0;i<len;i++){
                    if(a.get(i)<b.get(i)){
                        return -1;
                    }
                    else if(a.get(i)>b.get(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });
        return ar;
    }

    static void f(HashSet<ArrayList<Integer>> ar,ArrayList<Integer> a,ArrayList<Integer> tmp,boolean[] tk,int ct,int n){
        if(ct==n){
            ArrayList<Integer> b=new ArrayList<>(tmp);
            ar.add(b);
            return;
        }
        for(int i=0;i<n;i++){
            if(!tk[i]){
                tmp.add(a.get(i));
                tk[i]=true;
                f(ar,a,tmp,tk,ct+1,n);
                tk[i]=false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}

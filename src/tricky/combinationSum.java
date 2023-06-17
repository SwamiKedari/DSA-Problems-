package tricky;
import java.util.*; 
public class combinationSum {
    class Solution {
        // Function to return a list of indexes denoting the required
        // combinations whose sum is equal to the given number.
        static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            TreeSet<Integer> set = new TreeSet<>(A);
            A = new ArrayList<>(set);
            ArrayList<Integer> temp = new ArrayList<>();
            check(A, B, list, temp, 0);
            return list;
        }

        public static void check(ArrayList<Integer> A, int B, ArrayList<ArrayList<Integer>> list,
                                 ArrayList<Integer> temp, int curr) {
            if(curr==A.size()){
                return;
            }
            if (B == 0) {
                list.add(new ArrayList<>(temp));
                return;
            }
            if (B < 0) {
                return;
            }
            for(int i=curr;i<A.size();i++){
                temp.add(A.get(i));
                check(A,B-A.get(i),list,temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
}

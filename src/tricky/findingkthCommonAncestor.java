package tricky;
import java.util.*;
public class findingkthCommonAncestor {
// we can just find the path from that node to the root for both x and y
    // then we can find the common elements between both of them 
    public int pthAncestor(Node root, int x, int y, int p, ArrayList<Integer> s){
        //Write your code here
        ArrayList<Integer> ar=new ArrayList<>();
        ArrayList<Integer> ar1=new ArrayList<>();
        getf(root,x,ar);
        getf(root,y,ar1);
        HashSet<Integer> set=new HashSet<>();
        //System.out.println(ar.toString());
        //System.out.println(ar1.toString());
        for(int val: ar){
            set.add(val);
        }
        //System.out.println(set.toString());
        for(int i=0;i<ar1.size();i++){
            if(set.contains(ar1.get(i))){
                p--;
            }
            if(p==0){
                return ar1.get(i);
            }
        }

        return -1;
    }

    public boolean getf(Node root,int x,ArrayList<Integer> a){
        if(root==null){
            return false;
        }
        if(root.data==x){
            a.add(root.data);
            return true;
        }
        boolean k=getf(root.left,x,a);
        boolean k1=getf(root.right,x,a);
        if(k1|k){
            a.add(root.data);
        }
        return k1|k;
    }

}

package tricky;
import java.util.*;
public class largestIndependentSetProblem {
    // this is the problem on dp on trees, we are storing the values of the largest independent set for each node in the tree so that when they are called again, we can directly call them from the node itseld
    // this will give the answer for the question 
    class Solution {
        HashMap<Node,Integer> map=new HashMap<>();
        public int LISS(Node root){
            if(root==null){
                return 0;
            }
            if(map.containsKey(root)){
                return map.get(root);
            }
            int skip=LISS(root.left)+LISS(root.right);
            int keep=1;
            Node a1=root.left, a2=root.right;
            if(a1!=null){
                keep+=LISS(a1.left)+ LISS(a1.right);
            }
            if(a2!=null){
                keep+=LISS(a2.left)+LISS(a2.right);
            }
            map.put(root,Math.max(skip,keep));
            return map.get(root);

        }


    }
}
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}

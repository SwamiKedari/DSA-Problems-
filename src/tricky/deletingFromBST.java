package tricky;
import java.util.*;
public class deletingFromBST {
    // Function to delete a node from BST.
    // this involves the program to delete the node from bst in o(n) time

    public static Node deleteNode(Node rt, int x) {
        // code here.
        ArrayList<Node> ar=new ArrayList<>();
        ArrayList<Node> ar1=new ArrayList<>();
        inorder(rt,ar);
        for(int i=0;i<ar.size();i++){
            ar.get(i).left=null;
            ar.get(i).right=null;
            if(ar.get(i).data!=x){
                ar1.add(ar.get(i));
            }
        }

        // then we will reform the tree using the remaining nodes that are present in the tree
        // System.out.println(ar1.toString());
        Node ans=build(ar1,0,ar1.size()-1);
        return ans;
    }

    public static Node build(ArrayList<Node> ar,int i,int j){
        if(i<=j){
            int mid=(i+j)/2;
            ar.get(mid).left=build(ar,i,mid-1);
            ar.get(mid).right=build(ar,mid+1,j);
            return ar.get(mid);
        }
        return null;
    }


    public static void inorder(Node rt,ArrayList<Node> ar){
        if(rt==null){
            return;
        }
        inorder(rt.left,ar);
        ar.add(rt);
        inorder(rt.right,ar);
    }

}

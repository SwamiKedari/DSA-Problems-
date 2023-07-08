package tricky;
import java.util.*;
public class nodeAtDistanceKFromLeaf {
    //Function to return count of nodes at a given distance from leaf nodes.

    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        // we will use the arraylist and backtracking to get the answer
        // the arraylist will store all the nodes in the path
        // we will remove the nodes from the list while backtracking and thus, while the current call we will get the path from the root to that node in the tree to the leaf
        // this will help us to find the kth node from the end and thus the answer 
        ArrayList<Node> ar=new ArrayList<>();
        HashSet<Node> set=new HashSet<>();
        getans(root,ar,set,k);
        return set.size();
    }

    void getans(Node root,ArrayList<Node> ar,HashSet<Node> set,int k){
        if(root==null){
            return;
        }
        if(isleaf(root)){
            int len=ar.size();
            if(k<=len){
                set.add(ar.get(len-k));
            }
            return;
        }
        ar.add(root);
        getans(root.left,ar,set,k);
        getans(root.right,ar,set,k);
        ar.remove(ar.size()-1);

    }

    boolean isleaf(Node root){
        if(root!=null && root.left==null && root.right==null){
            return true;
        }
        return false;
    }

}

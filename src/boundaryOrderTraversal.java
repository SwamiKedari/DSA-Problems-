import java.util.ArrayList;
import java.util.Stack;

public class boundaryOrderTraversal {
    ArrayList<Integer> boundary(treeNode node)
    {
        // first store the left boundary
        // then store all the nodes
        // then store all the right nodes of the binary tree

        ArrayList<Integer> a=new ArrayList<>(); // the left boundary is stored in straight order
        if(node==null){
            return null;
        }
        if(isLeaf(node)){
            a.add(node.data);
            return a;
        }
        a.add(node.data);
        addLeftNodes(node.left,a);
        addLeaf(node,a);
        Stack<Integer> b=new Stack<>(); //stack is used to store the elements in reverse order
        addRight(node.right,b);

        while(b.size()>0){
            a.add(b.pop());
        }
        return a;

    }

    void addLeftNodes(treeNode root,ArrayList<Integer> a){
        if(isLeaf(root) || root==null){
            return;
        }
        a.add(root.data);
        if(root.left!=null){
            addLeftNodes(root.left,a);
        }
        else if(root.right!=null){
            addLeftNodes(root.right,a);
        }

    }
    boolean isLeaf(treeNode root){
        if(root!=null && root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    void addLeaf(treeNode root,ArrayList<Integer> a){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            a.add(root.data);
            return;
        }
        addLeaf(root.left,a);
        addLeaf(root.right,a);
    }
    void addRight(treeNode root, Stack<Integer> b){
        if(isLeaf(root) || root==null){
            return;
        }

        b.push(root.data);

        if(root.right!=null){
            addRight(root.right,b);
        }
        else if(root.left!=null){
            addRight(root.left,b);
        }
    }
}

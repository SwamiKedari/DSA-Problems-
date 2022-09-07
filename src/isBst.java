import java.util.ArrayList;

public class isBst {
    //the method to be used is to store the inorder traversal of the bst and check if it is sorted
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(treeNode root)
    {
        //inorderTraversal(root);
        ArrayList<Integer> a=new ArrayList<>();
        inorderTraversal(root,a);
        for(int i=0;i<a.size()-1;i++){
            if(a.get(i)>a.get(i+1)){
                return false;
            }
        }
        return true;

    }
    void inorderTraversal(treeNode root, ArrayList<Integer> a){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,a);
        a.add(root.data);
        inorderTraversal(root.right,a);
    }
}

package tricky;

public class binaryTreeToCDLL
{
    //Function to convert binary tree into circular doubly linked list.
    static Node pivot=null;
    Node bTreeToClist(Node root)
    {
        //your code here
        inorder(root);
        Node k=pivot;
        while(pivot.left!=null){
            pivot=pivot.left;
        }
        k.right=pivot;
        pivot.left=k;
        Node ans=pivot;
        pivot=null;
        return ans;
    }

    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(pivot!=null){
            pivot.right=root;
            root.left=pivot;
        }
        pivot=root;
        inorder(root.right);
    }

}



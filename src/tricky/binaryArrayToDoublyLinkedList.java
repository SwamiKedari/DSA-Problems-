package tricky;

public class binaryArrayToDoublyLinkedList {
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        //  Your code here
        // we need to use the proper recursive solution to solve this problem
        // without using the extra space, we need to find the answer
        // we will take the left node and save it in the curr array element
        // this will help us to use it and to make left and right pointers
        // after making the left and the right pointers, we can get the answer easily
        Node temp=new Node(-1);
        Node[] cur=new Node[1];
        cur[0]=temp;
        inorder(root,cur);
        Node ans=cur[0];
        while(ans!=null && ans.left!=null && ans.left.data!=-1){
            ans=ans.left;
        }
        Node k=ans.left;
        k.right=null;
        ans.left=null;
        return ans;
    }

    void inorder(Node root,Node[] cur){
        if(root==null){
            return;
        }
        inorder(root.left,cur);
        root.left=cur[0];
        cur[0].right=root;
        cur[0]=root;
        inorder(root.right,cur);
    }
}

package tricky;
import java.util.*;
public class preorderTraversal {
    //Iterative way of preorder traversal is similar to the level order traversal, we use the stack instead of the queue
    // also we insert the right node first and then the left node
    // this helps us to get the answer
    // Return a list containing the Preorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        // Code
        // we will use a stack, we will put the root in the stack, remove it and then put its right and left in the stack
        // we will continue this process to get the answer
        Stack<Node> st=new Stack<>();
        ArrayList<Integer> ar=new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){
            Node k=st.pop();
            ar.add(k.data);
            if(k.right!=null){
                st.push(k.right);
            }
            if(k.left!=null){
                st.push(k.left);
            }
        }

        return ar;
    }

}

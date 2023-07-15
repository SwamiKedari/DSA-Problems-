package tricky;
import java.util.*;
public class postorderTraversal {
    // through observation, the question of the preorder and the postorder traversal is similar to level order traversal with some modifications
    // in the postorder traversal, we use the stack, and we put the left node first and then the right node
    // after that we reverse the arraylist that we get to get the answer
    // this will give the answer for the postorder traversal 
    ArrayList<Integer> postOrder(Node node) {
        // code here
        // we will need to use the stack datastructure
        Stack<Node> st=new Stack<>();
        st.push(node);
        ArrayList<Integer> ar=new ArrayList<>();
        Stack<Integer> ar1=new Stack<>();
        while(!st.isEmpty()){
            Node k=st.pop();
            ar1.push(k.data);
            if(k.left!=null){
                st.push(k.left);
            }
            if(k.right!=null){
                st.push(k.right);
            }
        }
        while(!ar1.isEmpty()){
            ar.add(ar1.pop());
        }
        return ar;


    }
}

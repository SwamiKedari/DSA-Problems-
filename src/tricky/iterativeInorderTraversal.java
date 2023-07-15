package tricky;
import java.util.*;
public class iterativeInorderTraversal {
    // in this problem , we will use the stack to get the iterative inorder traversal of this tree
    // used two functions same as the bstiterator class
    // we need to push all the nodes to the left till they are not null
    // while removing we need to do the same thing for the root.right
    // using a stack gives the nodes in inorder traversal

    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer> ar=new ArrayList<>();
        Stack<Node> st=new Stack<>();
        pushall(root,st);
        int l=next(st);
        while(l!=-1){
            ar.add(l);
            l=next(st);
        }
        return ar;
    }
    public int next(Stack<Node> st){
        if(st.isEmpty()){
            return -1;
        }
        Node k=st.pop();
        pushall(k.right, st);
        return k.data;
    }
    public void pushall(Node k, Stack<Node> st){
        while(k!=null){
            st.push(k);
            k=k.left;
        }
    }

}

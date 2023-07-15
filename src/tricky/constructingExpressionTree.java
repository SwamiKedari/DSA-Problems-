package tricky;
import java.util.*;
public class constructingExpressionTree {
    public static Node constructTree(char pf[])
    {
        // we will use the stack to solve this problem
        // the expression tree can be formed by taking two nodes at a time, adding left and right pointers and then putting back the main root to the stack
        // this is the way we can form the tree using the postorder traversal
        Stack<Node> st=new Stack<>();
        for(int i=0;i<pf.length;i++){
            char ch=pf[i];
            Node k=new Node(ch);
            if(ch=='*'||ch=='/'||ch=='+'||ch=='-'||ch=='^'){
                Node a1=st.pop();
                Node a2=st.pop();
                k.left=a2;k.right=a1;
                st.push(k);
            }
            else{
                st.push(k);
            }
        }

        return st.pop();
    }
}

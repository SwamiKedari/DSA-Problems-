package tricky;
import java.util.*;
public class bstIterator
{
    // root : the root Node of the given BST
    // target : the target sum
    // in this problem, we have used the bst iterator which helps us to find the elements from the left and from the right in the bst in o(1) extra space
    // only extra space used is the stack space which is the o(h)
    // we can use this functions to solve the problem of the iterative inorder traversals
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        nextIter a=new nextIter(root);
        preIter b=new preIter(root);
        int l=a.next(), r=b.prev();
        while(l<r && l!=-1 && r!=-1){
            //System.out.println(l+" "+r);
            if(l+r<target){
                l=a.next();
            }
            else if(l+r>target){
                r=b.prev();
            }
            else{
                return 1;
            }
        }

        return 0;

    }
}

class nextIter
{
    Stack<Node> st=new Stack<>();
    public nextIter(Node root){
        pushall(root);
    }

    public int next(){
        if(st.isEmpty()){
            return -1;
        }
        Node k=st.pop();
        pushall(k.right);
        return k.data;
    }

    public void pushall(Node k){
        while(k!=null){
            st.push(k);
            k=k.left;
        }
    }
}

class preIter
{
    Stack<Node> st=new Stack<>();
    public preIter(Node root){
        pushall(root);
    }
    public int prev(){
        if(st.isEmpty()){
            return -1;
        }
        Node k=st.pop();
        pushall(k.left);
        return k.data;
    }

    public void pushall(Node k){
        while(k!=null){
            st.push(k);
            k=k.right;
        }
    }
}

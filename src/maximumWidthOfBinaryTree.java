import java.util.*;

public class maximumWidthOfBinaryTree {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(treeNode root) {
        // Your code here
        // do level order traversal using 2 queues and keep the track of the size of the queue
        // update the variable max if the queue size is greater than it
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        Queue<treeNode> a=new LinkedList<>();
        Queue<treeNode> b=new LinkedList<>();
        int i=1;
        a.add(root);
        int max=0;
        return max(a,b,i,max);

    }
    int max(Queue<treeNode> a,Queue<treeNode> b,int i,int max){
        if(i%2==1){
            if(a.size()==0){
                return max;
            }
            while(a.size()>0){
                treeNode k=a.remove();
                if(k.left!=null){
                    b.add(k.left);
                }
                if(k.right!=null){
                    b.add(k.right);
                }
            }
            if(b.size()>max){
                max=b.size();
            }
        }
        else{
            if(b.size()==0){
                return max;
            }
            while(b.size()>0){
                treeNode k=b.remove();
                if(k.left!=null){
                    a.add(k.left);
                }
                if(k.right!=null){
                    a.add(k.right);
                }
            }
            if(a.size() >max){
                max=a.size();
            }
        }
        i++;
        return max(a,b,i,max);
    }

}

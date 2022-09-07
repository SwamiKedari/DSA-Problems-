import java.util.*;
public class levelOrderTraversal {
    static ArrayList <Integer> levelOrder(treeNode node)
    {
        // Your code here
        // add the root to the queue , then remove it ,add it to the list and then add its childrens to the queue
        Queue<treeNode> a=new LinkedList<>();
        ArrayList<Integer> b=new ArrayList<>();
        a.add(node);
        levelOrder(b,a);

        return b;

    }

    static void levelOrder( ArrayList<Integer> a , Queue<treeNode> b ){
        if(b.size()==0){
            return;
        }
        treeNode c=b.remove();
        a.add(c.data);

        if(c.left!=null){
            b.add(c.left);
        }
        if(c.right!=null){
            b.add(c.right);
        }
        levelOrder(a,b);
    }
}

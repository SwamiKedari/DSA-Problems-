
import java.util.*;
public class addSiblings {
    ArrayList<Integer> noSibling(treeNode node)
    {
        // code here

        ArrayList<Integer> a=new ArrayList<>();
        addSibling(node,a);
        if(a.size()==0){
            a.add(-1);
        }
        Collections.sort(a);
        return a;
    }
    void addSibling(treeNode node,ArrayList<Integer> a){
        if(node==null){
            return;
        }
        if(node.left!=null&&node.right==null){
            a.add(node.left.data);
        }
        else if(node.right!=null&& node.left==null){
            a.add(node.right.data);
        }
        addSibling(node.left,a);
        addSibling(node.right,a);
    }
}

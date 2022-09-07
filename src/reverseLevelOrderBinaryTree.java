import java.util.*;


public class reverseLevelOrderBinaryTree {


    public ArrayList<Integer> reverseLevelOrder(treeNode node)
    {
        // code here
        // just do the level order traversal with right child first and left child next and then reverse the arraylist we get
        Queue<treeNode> a=new LinkedList<>();
        ArrayList<Integer> b=new ArrayList<>();
        ArrayList<Integer> c=new ArrayList<>();

        a.add(node);
        addToList(b,a);

        int n=b.size();
        for(int i=n-1;i>-1;i--){
            c.add(b.get(i));
        }

        return c;
    }

    public void addToList(ArrayList<Integer> a,Queue<treeNode> b){
        if(b.size()==0){
            return ;
        }
        treeNode k=b.remove();
        a.add(k.data);
        if(k.right!=null){
            b.add(k.right);
        }
        if(k.left!=null){
            b.add(k.left);
        }

        addToList(a,b);
    }







}

import java.util.*;
public class bottomViewOfBinaryTree {
    public ArrayList <Integer> bottomView(treeNode root)
    {
        // Code here
        // we need to do level order traversal on the given tree
        // then we need to use a data structure to store the distance of the elements from the root
        // we will need a hashmap , an queue to do the level order traversal
        Queue<Integer> a=new LinkedList<>();
        HashMap<Integer,Integer> b=new HashMap<>();
        Queue<treeNode> c=new LinkedList<>();
        a.add(0);
        c.add(root);
        b.put(0,root.data);
        levelOrder(a,c,b);
        //System.out.println(b);
        ArrayList<Integer> v=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i : b.keySet()){
            if(min>i){
                min=i;
            }
        }

        while(b.containsKey(min)){
            v.add(b.get(min));
            min++;
        }
        return v;
    }
    public void levelOrder(Queue<Integer> a,Queue<treeNode> c,HashMap<Integer,Integer> b){
        if(c.size()==0){
            return;
        }
        int k=a.remove();
        treeNode n=c.remove();
        b.put(k,n.data);
        if(n.left!=null){
            c.add(n.left);
            a.add(k-1);
        }
        if(n.right!=null){
            c.add(n.right);
            a.add(k+1);
        }
        levelOrder(a,c,b);
    }
}

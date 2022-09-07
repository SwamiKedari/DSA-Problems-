import java.util.*;

public class rightViewOfBinaryTree {
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(treeNode node) {
        //add code here.
        // store the tree nodes and the right nodes ,
        // do level order traversal with right child inserted first and then the left child and add the last node in the arraylist
        ArrayList<Integer> a=new ArrayList<>();
        Queue<treeNode> b=new LinkedList<>();
        Queue<treeNode> c=new LinkedList<>();
        b.add(node);
        int i=1;
        addToList(a,b,c,i);

        return a;

    }

    public void addToList(ArrayList<Integer> a,Queue<treeNode> b,Queue<treeNode> c,int j){
        if((j%2==1)){
            if(b.size()==0){
                return ;
            }
            int i=1;
            while(b.size()!=0){
                treeNode k=b.remove();

                if(i==1){
                    a.add(k.data);
                    i++;
                }
                if(k.right!=null){
                    c.add(k.right);
                }
                if(k.left!=null){
                    c.add(k.left);
                }
            }
        }
        else{
            if(c.size()==0){
                return ;
            }
            int i=1;
            while(c.size()!=0){
                treeNode k=c.remove();

                if(i==1){
                    a.add(k.data);
                    i++;
                }
                if(k.right!=null){
                    b.add(k.right);
                }
                if(k.left!=null){
                    b.add(k.left);
                }
            }
        }
        j++;

        addToList(a,b,c,j);

    }

}

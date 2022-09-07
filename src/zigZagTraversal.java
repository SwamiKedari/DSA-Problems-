import java.util.*;
public class zigZagTraversal {
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(treeNode root)
    {
        //Add your code here.
        // we will need to maintain 2 stacks
        // we will use this stacks to keep track of odd levels and even levels
        Stack<treeNode> a=new Stack<>();
        Stack<treeNode> b=new Stack<>();

        ArrayList<Integer> c=new ArrayList<>();
        int i=1;
        a.add(root);
        addToList(a,b,c,i);


        return c;
    }


    public void addToList(Stack<treeNode> a,Stack<treeNode> b,ArrayList<Integer> c,int i){
        if(i%2==1){
            if(a.size()==0){
                return;
            }
            while(a.size()>0){
                treeNode k=a.pop();
                c.add(k.data);
                if(k.left!=null){
                    b.push(k.left);
                }
                if(k.right!=null){
                    b.push(k.right);
                }
            }

        }
        if(i%2==0){
            if(b.size()==0){
                return;
            }
            while(b.size()>0){
                treeNode k=b.pop();
                c.add(k.data);
                if(k.right!=null){
                    a.push(k.right);
                }
                if(k.left!=null){
                    a.push(k.left);
                }
            }

        }

        i++;
        addToList(a,b,c,i);

    }
}

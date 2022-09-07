import java.util.*;

public class spiralLevelOrder {
    //Function to return a list containing the level order
    //traversal in spiral form.
    ArrayList<Integer> findSpiral(treeNode root)
    {
        // Your code here
        // use a counter to keep a track of whether the level is odd or even
        // maintain 2 stacks , add one stack right and left , and in second , add stack left and right
        ArrayList<Integer> a=new ArrayList<>();
        if(root==null){
            return a ;
        }

        Stack<treeNode> b=new Stack<>();
        Stack<treeNode> c=new Stack<>();
        int i=1;
        b.push(root);
        spiral(a,b,c,i);
        return a;

    }

    void spiral(ArrayList<Integer> a , Stack<treeNode> b,Stack<treeNode> c ,int i){

        if(i%2==1){
            if(b.size()==0){
                return ;
            }
            while(b.size()!=0){
                treeNode d=b.pop();

                a.add(d.data);
                if(d.right!=null){
                    c.push(d.right);
                }
                if(d.left!=null){
                    c.push(d.left);
                }
            }
        }
        else{
            if(c.size()==0){
                return ;
            }
            while(c.size()!=0)
            {
                treeNode d=c.pop();
                a.add(d.data);
                if(d.left!=null){
                    b.push(d.left);
                }
                if(d.right!=null){
                    b.push(d.right);
                }
            }
        }
        i++;
        spiral(a,b,c,i);
    }
}

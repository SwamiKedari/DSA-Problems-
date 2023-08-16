package tricky;

public class deletingFromBSTI {
    // Function to delete a node from BST.
    static Node mainrt=new Node(-1);
    public static Node deleteNode(Node rt,int x) {
        // code here.
        // deleting the node from the bst can involve following cases:
        //1 the node to be deleted is leaf node, then simply delete it
        //2 if the node to be deleted has only left child or the right child, replace that node with its left child or right child
        //3 if the node to be deleted has both the childs, replace the node with its inorder successor or the inorder predecessor
        mainrt=rt;
        if(rt.data==x){
            if(rt.left==null){
                return rt.right;
            }
            else if(rt.right==null){
                return rt.left;
            }
            else{
                getsuc(rt,rt.right);
            }
            return rt;
        }
        delete(rt,x);
        return mainrt;
    }

    public static void delete(Node rt,int x){
        if(rt==null){
            return;
        }
        if(rt.data>x){
            delete(rt.left,x);
        }
        else if(rt.data<x){
            delete(rt.right,x);
        }
        else if(rt.data==x){
            if(isl(rt)){
                //System.out.println(mainrt.data);
                dell(mainrt,x);
            }
            else if((rt.right==null && rt.left!=null) || (rt.left==null && rt.right==null)){
                delpar(mainrt,x);
            }
            else{
                getsuc(rt,rt.right);
            }
        }
    }

    public static void getsuc(Node rt,Node rt1){
        if(rt1.left==null){
            int temp=rt.data;
            int temp1=rt1.data;
            if(rt1.right==null){
                dell(rt,temp1);
                rt.data=temp1;
            }
            else{
                delpar(rt,temp1);
                rt.data=temp1;
            }
            return;
        }
        getsuc(rt,rt1.left);
    }

    public static void dell(Node rt,int x){
        if(rt==null){
            return;
        }
        if(rt.left!=null && rt.left.data==x){
            rt.left=null;
            return;
        }
        if(rt.right!=null && rt.right.data==x){
            rt.right=null;
            return;
        }
        if(x>rt.data){
            dell(rt.right,x);
        }
        else{
            dell(rt.left,x);
        }

    }

    public static void delpar(Node rt,int x){
        if(rt==null){
            return;
        }
        if(rt.left!=null && rt.left.data==x){
            if(rt.left.left!=null){
                rt.left=rt.left.left;
            }
            else if(rt.left.right!=null){
                rt.left=rt.left.right;
            }
            return;
        }
        if(rt.right!=null && rt.right.data==x){
            if(rt.right.left!=null){
                rt.right=rt.right.left;
            }
            else if(rt.right.right!=null){
                rt.right=rt.right.right;
            }
            return;
        }
        if(x>rt.data){
            delpar(rt.right,x);
        }
        else{
            delpar(rt.left,x);
        }

    }
    public static boolean isl(Node rt){
        if(rt.left==null && rt.right==null){
            return true;
        }
        return false;
    }
}

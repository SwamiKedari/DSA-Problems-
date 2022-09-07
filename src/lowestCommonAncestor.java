public class lowestCommonAncestor {
    //Function to find the lowest common ancestor in a BST. 
    treeNode LCA(treeNode root, int n1, int n2)
    {
        // code here.   
        boolean t1=searchLeft(root,n1) , t2=searchRight(root,n1);
        boolean t3=searchLeft(root,n2) , t4=searchRight(root,n2);
        if((t1&&t4)||(t2&&t3)||(t1&&t2)||(t3&&t4)){
            return root;
        }
        else if((t2&&t4)){
            return LCA(root.right,n1,n2);
        }
        else{
            return LCA(root.left,n1,n2);
        }
    }

    boolean searchLeft(treeNode root , int n1){
        if(root==null){
            return false;
        }
        if(root.data==n1){
            return true;
        }
        return search(root.left,n1);
    }

    boolean searchRight(treeNode root,int n2){
        if(root==null){
            return false;
        }
        if(root.data==n2){
            return true;
        }
        return search(root.right,n2);
    }

    boolean search(treeNode root, int n){
        if(root==null){
            return false;
        }
        if(root.data==n){
            return true;
        }
        return search(root.left,n)||search(root.right,n);
    }
}

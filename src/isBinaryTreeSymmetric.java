public class isBinaryTreeSymmetric {
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(treeNode root)
    {
        // add your code here;
        if(root==null){
            return true;
        }
        // use another function with more parameters , and pass root.left and root.right to it
        return isSym(root.left,root.right);
    }

    public static boolean isSym(treeNode a , treeNode b){
        if(a==null && b==null){
            return true;
        }
        if((a==null && b!=null) || (a!=null && b==null)){
            return false;
        }

        return a.data==b.data && isSym(a.left,b.right) && isSym(a.right,b.left);
    }
}

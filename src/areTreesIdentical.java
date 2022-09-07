public class areTreesIdentical {
    //Function to check if two trees are identical.
    boolean isIdentical(treeNode root1, treeNode root2)
    {
        // Code Here
        // this code gives the boolean value of true or false depending on the tree checking
        // it is recursive function with time complexity O(n)
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null||root1.data!=root2.data){
            return false;
        }
        boolean t1=isIdentical(root1.left,root2.left);
        boolean t2=isIdentical(root1.right,root2.right);
        return t1&& t2;
    }
}

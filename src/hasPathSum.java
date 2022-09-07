public class hasPathSum {
    /*you are required to complete this function */
    boolean hasPathSum(treeNode root, int s) {
        // Your code here
        // traverse from all paths from root to the leaf , and then store the values in the array and  then find the value equal to s
        // get the paths from root to the leaf and then find the value of the
        if(root.left==null && root.right==null && s==root.data){
            return true;
        }
        boolean a1=false , a2=false;
        if(root.left!=null){
            a1=hasPathSum(root.left,s-root.data);
        }

        if(root.right!=null){
            a2=hasPathSum(root.right,s-root.data);
        }
        return a1 || a2;
    }

}

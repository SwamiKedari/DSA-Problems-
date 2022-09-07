public class leftLeavesSum {
    // we have to find the sum of the leaf nodes that are only on the left child of any root
    public int leftLeavesSum(treeNode root)
    {
        // Write your code here
        if(root==null){
            return 0;
        }
        if(isLeaf(root.left)){
            return root.left.data+leftLeavesSum(root.right);
        }
        return leftLeavesSum(root.left)+leftLeavesSum(root.right);


    }
    public boolean isLeaf(treeNode root){
        if(root!=null && root.left==null && root.right==null){
            return true;
        }
        return false;
    }

}

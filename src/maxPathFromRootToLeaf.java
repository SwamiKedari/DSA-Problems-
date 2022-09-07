public class maxPathFromRootToLeaf {
    public static int maxPathSum(treeNode root)
    {
        //code here
        if(isLeaf(root)){
            return root.data;
        }
        if(halfLeaf(root)){
            if(root.right!=null){
                return root.data + maxPathSum(root.right);
            }
            else{
                return root.data + maxPathSum(root.left);
            }
        }
        int a=maxPathSum(root.left);
        int b=maxPathSum(root.right);
        return Math.max(a,b)+root.data;
    }
    public static boolean isLeaf(treeNode root){
        if(root!=null && root.right==null && root.left==null){
            return true;
        }
        return false;
    }
    public static boolean halfLeaf(treeNode root){
        if( (root.left!=null ^ root.right!=null)){
            return true;
        }
        return false;
    }
}

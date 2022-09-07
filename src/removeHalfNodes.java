public class removeHalfNodes {
    // Return the root of the modified tree after removing all the half nodes.
// doubt
    public static treeNode RemoveHalfNodes(treeNode root)
    {
        // Code Here
        RemoveHalfNode(root);
        return root;

    }


    public static void RemoveHalfNode(treeNode root)
    {
        // Code Here
        if(root==null){
            return;
        }
        if(isHalf(root.left)){
            root.left=getLink(root.left);
        }
        if(isHalf(root.right)){
            root.right=getLink(root.right);
        }

        RemoveHalfNode(root.left);
        RemoveHalfNode(root.right);

    }



    public static boolean isHalf(treeNode root){
        if(root!=null ){
            if(root.left==null && root.right==null){
                return false;
            }
            if(root.left==null || root.right==null){
                return true;
            }
            return false;
        }
        return false;
    }

    public static treeNode getLink(treeNode root){
        if(root!=null){
            if(root.left==null){
                if(isHalf(root.right)){
                    return getLink(root.right);
                }
                else{
                    return root.right;
                }
            }
            if(isHalf(root.left)){
                return getLink(root.left);
            }
            else{
                return root.left;
            }
        }
        return null;
    }
}

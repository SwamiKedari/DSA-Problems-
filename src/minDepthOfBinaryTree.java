public class minDepthOfBinaryTree {
    int minDepth(treeNode root)
    {
        //code here
        // at the root level , minDepth is 1+min(minDepth(root.left),minDepth(root.right));
        // minimum depth is the shortest path from the root to the leaf node
        if(root.left==null && root.right==null){
            return 1;
        }

        if(root.left==null){
            return 1+minDepth(root.right);
        }
        if(root.right==null){
            return 1+minDepth(root.left);
        }

        return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }
}

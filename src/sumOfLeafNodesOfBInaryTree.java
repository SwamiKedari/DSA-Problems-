public class sumOfLeafNodesOfBInaryTree {
    //this code gives the sum of all the leaf nodes of the bst
    // recursive approach
    public int SumofLeafNodes(treeNode root)
    {
        // your code here
        if(root!=null && root.left==null && root.right==null ){
            return root.data;
        }

        if(root!=null && root.right==null && root.left!=null){
            return SumofLeafNodes(root.left);
        }
        if(root!=null && root.left==null && root.right!=null){
            return SumofLeafNodes(root.right);
        }

        return SumofLeafNodes(root.left)+SumofLeafNodes(root.right);
    }
}

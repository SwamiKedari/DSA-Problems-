public class convertingToSumTree {

    public void toSumTree(treeNode root){
        //add code here.
        //we need to get the sum of left and right child inorder to get the node data value
        //we recursively add the addition of the nodes from the subtree to the root and pass the addition to the next upper side

        sumOfNodes(root);
    }

    public int sumOfNodes(treeNode root){
        if(root==null){
            return 0;
        }
        int k=root.data;
        root.data=sumOfNodes(root.left) + sumOfNodes(root.right);
        return k+root.data;

    }

}

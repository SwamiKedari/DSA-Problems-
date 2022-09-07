public class reverseAlternateBinaryLevelNodes {
    // we have to reverse the datas of the alternate nodes in a perfect binary tree
    // code for the same
    static void reverseAlternate( treeNode root)
    {
        // code here.
        int i=0;
        reverse(root.left,root.right,i);

    }
    static void swapData(treeNode root,treeNode root1){
        int temp=root.data;
        root.data=root1.data;
        root1.data=temp;
    }
    static void reverse(treeNode root,treeNode root1,int i){
        if(root==null || root1==null){
            return;
        }
        if(i%2==0){
            swapData(root,root1);
        }
        i++;
        reverse(root.left,root1.right,i);
        reverse(root.right,root1.left,i);
    }
}

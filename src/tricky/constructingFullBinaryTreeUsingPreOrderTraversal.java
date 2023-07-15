package tricky;

public class constructingFullBinaryTreeUsingPreOrderTraversal {
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        // we are given with the preorder traversal and the preorder of the mirror , we need to construct the binary tree using the two
        // we can solve this problem just using the pre order traversal and prem is not needed
        int i=0, j=size-1;
        Node ans=getans(pre,i,j);
        return ans;
    }

    public Node getans(int[] pr,int i,int j){
        if(i>j){
            return null;
        }
        Node k=new Node(pr[i]);
        int size=(j-i)/2;
        k.left=getans(pr,i+1,i+1+size-1);
        k.right=getans(pr,i+1+size,j);
        return k;
    }
}

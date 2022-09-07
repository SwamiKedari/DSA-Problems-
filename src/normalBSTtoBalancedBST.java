import java.util.ArrayList;

public class normalBSTtoBalancedBST {
    treeNode buildBalancedTree(treeNode root)
    {
        //Add your code here.
        // this is reverse of binary search , do inorder traversal , then do reverse binarysearch
        ArrayList<Integer> a=new ArrayList<>();
        inOrderTraversal(root,a);
        return makeTree(a,0,a.size()-1);
    }

    void inOrderTraversal(treeNode a,ArrayList<Integer> b){
        if(a==null){
            return;
        }
        inOrderTraversal(a.left,b);
        b.add(a.data);
        inOrderTraversal(a.right,b);
    }

    treeNode makeTree(ArrayList<Integer> b,int l,int h){
        if(l<=h){
            int mid=(l+h)/2;
            treeNode root=new treeNode(b.get(mid));
            root.left=makeTree(b,l,mid-1);
            root.right=makeTree(b,mid+1,h);
            return root;
        }
        return null;
    }
}

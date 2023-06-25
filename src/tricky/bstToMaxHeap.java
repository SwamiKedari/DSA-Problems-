package tricky;

import java.util.* ;
public class bstToMaxHeap {
    public static void convertToMaxHeapUtil(Node root)
    {
        // code here
        // we are asked to convert the given binary tree to the max heap
        // we will do the inorder traversal and store all the values in the qwueue
        // and then we will again do the preorder traversal and then we will again store this values in the list
        ArrayList<Integer> ar=new ArrayList<>();
        addlist(root,ar);
        getans(root,ar);

    }

    public static void getans(Node root,ArrayList<Integer> ar){
        if(root==null){
            return;
        }
        root.data=ar.remove(ar.size()-1);
        getans(root.right,ar);
        getans(root.left,ar);
    }

    public static void addlist(Node root, ArrayList<Integer> ar){
        if(root==null){
            return ;
        }
        addlist(root.left,ar);
        ar.add(root.data);
        addlist(root.right,ar);
    }
}

public class isTreeBalanced {
    boolean isBalanced(treeNode root)
    {
        // Your code here
        // for height , the height will be equal to the max of height of its left root or right root +1
        // if the height of the left trees and right trees dont have the difference equal to 1 , then it is not a balanced tree
        // else it is a balanced tree
        // we will also check for the balance in the below parts of the tree as well
        if(root==null){
            return true;
        }

        int h1=height(root.left);
        int h2=height(root.right);
        if(Math.abs(h1-h2)>1){
            return false;
        }
        boolean t1= isBalanced(root.left);
        boolean t2= isBalanced(root.right);
        return t1&&t2;
    }

    int height(treeNode root){
        if(root==null){
            return 0;
        }
        return (1+Math.max(height(root.left),height(root.right)));
    }
}


class treeNode
{
    int data;
    treeNode left,right;

    treeNode(int d)
    {
        data = d;
        left = right = null;
    }
}
public class kthSmallestInBinaryTree {
    // no clear description
    // we need to find the kth smallest element in the binary tree in o(1) space complexity
    // we use the morris traversal to solve this problem

    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(treeNode root, int k) {
        // Write your code here
        // we need to find the kth smallest element in the array in o(1) space complexity
        // we can do it using inorder traversal but it requires o(n) space complexity
        // we will use the morris traversal which will get the inorder traversal of the tree in o(1) space complexity
        int count=0;
        treeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                count++;
                //System.out.println(curr.data);
                if(count==k){
                    return curr.data;
                }
                curr=curr.right;
            }
            else{
                treeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }
                else{
                    temp.right=null;
                    count++;
                    // System.out.println(curr.data);

                    if(count==k){
                        return curr.data;
                    }
                    curr=curr.right;
                }
            }
        }

        return -1;
    }
}

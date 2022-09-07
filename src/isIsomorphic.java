public class isIsomorphic {
    boolean isIsomorphic(treeNode root1, treeNode root2) {
        // code here.
        // doubt
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        if (root1.data == root2.data) {
            if ((isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left))) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}

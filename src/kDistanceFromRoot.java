import java.util.ArrayList;

public class kDistanceFromRoot {

        // Recursive function to find nodes with k distance from the node
        ArrayList<Integer> Kdistance(treeNode root, int k)
        {
            // Your code here
            ArrayList<Integer> a=new ArrayList<>();
            addNodes(root,k,a);
            return a;
        }

        void addNodes(treeNode root, int k, ArrayList<Integer> a){
            if(root==null){
                return;
            }
            if(k==0){
                a.add(root.data);
            }
            int h=k-1;
            addNodes(root.left,h,a);
            addNodes(root.right,h,a);
        }


}


import java.util.*;
public class exchangeLeafNodes {
    public void pairwiseSwap(treeNode root){
        //code here
        // first we took all the leaf nodes in the arraylist , then we swapped the adjacent node data
        // here , we have to swap the data of the leafs in the tree , we do by storing them in the arraylist and then swapping the adjacent nodes data

        ArrayList<treeNode> a=new ArrayList<>();
        getList(root,a);
        // printList(a);
        int k=a.size();
        if(k%2==0){
            for(int i=0;i<a.size()-1;i+=2){
                int temp=a.get(i).data;
                int temp1=a.get(i+1).data;
                a.get(i).data=temp1;
                a.get(i+1).data=temp;
            }
        }
        else{
            for(int i=0;i<a.size()-2;i+=2){
                int temp=a.get(i).data;
                int temp1=a.get(i+1).data;
                a.get(i).data=temp1;
                a.get(i+1).data=temp;
            }
        }



    }
    public void printList(ArrayList<treeNode> a){
        for(treeNode b: a){
            System.out.println(b.data);
        }
    }
    public void getList(treeNode root,ArrayList<treeNode> a){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            a.add(root);
        }
        getList(root.left,a);
        getList(root.right,a);
    }
    public boolean isLeaf(treeNode root){
        if(root!=null && root.left==null && root.right==null){
            return true;
        }
        return false;
    }
}

import java.util.*;
public class binaryTreeToGreaterSumTree {
    public static void transformTree (treeNode root)
    {
        //code here
        //we have to find the greater sum tree which means that the data in the node will have sum of the values greater than that value
        //make a array of nodes
        //also get the sum of total elements
        ArrayList<treeNode> arr=new ArrayList<>();
        int[] a = new int[1];
        inOrder(root,a,arr);
        int sum=a[0];
        int sum1=0;
        int len=arr.size();
        for(int i=0;i<len;i++){
            sum1+=arr.get(i).data;
            arr.get(i).data=sum-sum1;
        }


    }
    public static void inOrder(treeNode root ,int[] a,ArrayList<treeNode> arr){
        if(root==null){
            return;
        }
        inOrder(root.left,a,arr);
        a[0]+=root.data;
        arr.add(root);
        inOrder(root.right,a,arr);
    }
}

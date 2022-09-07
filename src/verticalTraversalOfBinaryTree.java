import java.util.*;
public class verticalTraversalOfBinaryTree {
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(treeNode root)
    {
        // add your code here
        // first we will do a level order traversal and know the size of arraylist of arraylist we need
        // then we will use arraylist of arraylist and add those elements in it
        // this solution is similar to the top view question in the binary tree

        int min=0 ,max=0;
        Queue<treeNode> que=new LinkedList<>();
        Queue<Integer> ind=new LinkedList<>();
        que.add(root);
        ind.add(0);
        while(que.size()>0){
            treeNode a =que.remove();
            int i=ind.remove();
            if(min>i){
                min=i;
            }
            if(max<i){
                max=i;
            }
            if(a.left!=null){
                que.add(a.left);
                ind.add(i-1);
            }
            if(a.right!=null){
                que.add(a.right);
                ind.add(i+1);
            }

        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int len=max-min+1;
        for(int i=0;i<len;i++){
            ans.add(new ArrayList<Integer>());
        }

        que=new  LinkedList<>();
        ind=new LinkedList<>();
        que.add(root);
        ind.add(0);
        while(que.size()>0){
            treeNode a =que.remove();
            int i=ind.remove();
            ans.get(i-min).add(a.data);
            if(a.left!=null){
                que.add(a.left);
                ind.add(i-1);
            }
            if(a.right!=null){
                que.add(a.right);
                ind.add(i+1);
            }
        }

        ArrayList<Integer> ans1=new ArrayList<>();
        for(ArrayList<Integer> a : ans){
            for(int a1 : a ){
                ans1.add(a1);
            }
        }
        return ans1;

    }
}

import java.util.*;

public class topView {
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(treeNode root)
    {
        // add your code
        // we will know the minimum line and the maximum line of the binary tree
        // then we will form the arraylist according to this lines
        HashMap<Integer,Integer> a=new HashMap<>();
        Queue<treeNode> b=new LinkedList<>();
        Queue<Integer> c=new LinkedList<>();
        b.add(root);
        c.add(0);
        int max=0 , min=0;
        while(b.size()>0){
            treeNode k=b.remove();
            int i=c.remove();
            if(min>i){
                min=i;
            }
            if(max<i){
                max=i;
            }
            if(!a.containsKey(i)){
                a.put(i,k.data);
            }
            if(k.left!=null){
                b.add(k.left);
                c.add(i-1);
            }
            if(k.right!=null){
                b.add(k.right);
                c.add(i+1);
            }
        }

        int size=max-min+1;
        //System.out.println(size);
        //System.out.println(min+" "+max);
        ArrayList<Integer> ans=new ArrayList<>(size);
        for(int i=0;i<size;i++){
            ans.add(0);
        }
        for(Map.Entry k : a.entrySet()){
            ans.set((int)k.getKey()+Math.abs(min),(int)k.getValue());
        }
        return ans;

        //return ans ;



    }
}

package tricky;
import java.util.*;
public class noOfTurnsInBinaryTree {
    static HashMap<Node,Node> l=new HashMap<>();
    static HashMap<Node,Node> r=new HashMap<>();
    // in this problem, instead of using the parent maps, we will the left parent and right parent maps which will help us to get the direction from the current node to the two nodes
    // this will help us to get the solution
    static HashSet<Node> vis=new HashSet<>();
    static int NumberOfTurns(Node root, int f, int s)
    {
        //your code here
        Node[] a=new Node[1];
        Node[] b=new Node[1];
        get(root,f,s,a,b);
        return dfs(a[0],0,s);
    }

    static int dfs(Node root,int dir,int s){
        vis.add(root);
        if(root.data==s){
            return 0;
        }
        int ans=(int)1e5;
        if(dir==0){
            if(root.left!=null && !vis.contains(root.left)){
                ans=Math.min(dfs(root.left,-1,s),ans);
            }
            if(root.right!=null && !vis.contains(root.right)){
                ans=Math.min(dfs(root.right,1,s),ans);
            }
            if(l.containsKey(root) && !vis.contains(l.get(root))){
                ans=Math.min(dfs(l.get(root),-1,s),ans);
            }
            if(r.containsKey(root) && !vis.contains(r.get(root))){
                ans=Math.min(dfs(r.get(root),1,s),ans);
            }
        }
        else if(dir==-1){
            if(root.left!=null && !vis.contains(root.left)){
                ans=Math.min(dfs(root.left,-1,s),ans);
            }
            if(root.right!=null && !vis.contains(root.right)){
                ans=Math.min(dfs(root.right,1,s)+1,ans);
            }
            if(l.containsKey(root) && !vis.contains(l.get(root))){
                ans=Math.min(dfs(l.get(root),-1,s),ans);
            }
            if(r.containsKey(root) && !vis.contains(r.get(root))){
                ans=Math.min(dfs(r.get(root),1,s)+1,ans);
            }
        }
        else{
            if(root.left!=null && !vis.contains(root.left)){
                ans=Math.min(dfs(root.left,-1,s)+1,ans);
            }
            if(root.right!=null && !vis.contains(root.right)){
                ans=Math.min(dfs(root.right,1,s),ans);
            }
            if(l.containsKey(root) && !vis.contains(l.get(root))){
                ans=Math.min(dfs(l.get(root),-1,s)+1,ans);
            }
            if(r.containsKey(root) && !vis.contains(r.get(root))){
                ans=Math.min(dfs(r.get(root),1,s),ans);
            }
        }
        return ans;
    }

    static void get(Node root,int f,int s,Node[] a,Node[] b){
        if(root==null){
            return;
        }
        if(root.data==f){
            a[0]=root;
        }
        if(root.data==s){
            b[0]=root;
        }
        if(root.left!=null){

            l.put(root.left,root);
            get(root.left,f,s,a,b);
        }
        if(root.right!=null){

            r.put(root.right,root);
            get(root.right,f,s,a,b);
        }
    }
}

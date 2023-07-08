package tricky;
import java.util.*;
public class burningTree {
     /*class Node {
    	int data;
    	Node left;
    	Node right;

    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/

    public static int minTime(Node root, int tr)
    {
        // Your code goes here
        // we can solve this problem using the bfs and finding the longest path in the tree which is present from the target node
        // we have to do the bfs on the tree and then solve the problem using the bfs,
        // before doing the bfs, we also need to make the parent pointers to each of the nodes so that we can traverse in the upward direction as well
        // this will help us to travel using bfs in the downward and the upward direction as well 
        HashMap<Node,Node> par=new HashMap<>();
        HashSet<Node> vis=new HashSet<>();
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        Node burn=new Node(-1);
        while(!que.isEmpty()){
            Node k=que.remove();
            Node l=k.left, r=k.right;
            if(k.data==tr){
                burn=k;
            }
            if(k.left!=null){
                par.put(l,k);
                que.add(l);
            }
            if(k.right!=null){
                par.put(r,k);
                que.add(r);
            }
        }
        // after making the backward edges from the given node, we will be able to solve the problem by doing the bfs traversal on the given node
        int dist=0;
        que.add(burn);
        while(!que.isEmpty()){
            int len=que.size();

            for(int i=0;i<len;i++){
                Node k=que.remove();
                //System.out.println(k.data);
                vis.add(k);
                if(k.left!=null && !vis.contains(k.left)){
                    que.add(k.left);
                }
                if(k.right!=null && !vis.contains(k.right)){
                    que.add(k.right);
                }
                if(par.get(k)!=null && !vis.contains(par.get(k))){
                    que.add(par.get(k));
                }
            }
            //System.out.println();
            dist++;
        }

        return dist-1;
    }

}

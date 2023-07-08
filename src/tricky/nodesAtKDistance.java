package tricky;
import java.util.*;
public class nodesAtKDistance {
    // in this problem, we have to use the backward pointers using the map in the target node and then use the backward, left and the right pointers to do the bfs on the tree
    // using the bfs, we can get the answer of the nodes which lie at the k distance from the target node

    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        // we will add the parent pointers in the tree so that we can apply the bfs traversal on it
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        Node t=new Node(-1);
        while(!que.isEmpty()){
            Node k1=que.remove();
            Node l=k1.left,r=k1.right;
            if(k1.data==target){
                t=k1;
            }
            if(l!=null){
                que.add(l);
                map.put(l,k1);
            }
            if(r!=null){
                que.add(r);
                map.put(r,k1);
            }
        }
        // after connecting the nodes in the queue, we can do the bfs traversal and find the nodes in that are at the distance of k units from the given ode
        int dist=0;
        que.add(t);
        HashSet<Node> set=new HashSet<>();
        while(!que.isEmpty() && dist<k){
            int size=que.size();
            for(int i=0;i<size;i++){
                Node k1=que.remove();
                set.add(k1);
                if(k1.left!=null && !set.contains(k1.left)){
                    que.add(k1.left);
                }
                if(k1.right!=null && !set.contains(k1.right)){
                    que.add(k1.right);
                }
                if(map.get(k1)!=null && !set.contains(map.get(k1))){
                    que.add(map.get(k1));
                }

            }
            dist++;
        }

        // after finding the nodes, we can output them
        ArrayList<Integer> ar=new ArrayList<>();
        while(!que.isEmpty()){
            ar.add(que.peek().data);
            que.remove();
        }
        Collections.sort(ar);
        return ar;

    }
}

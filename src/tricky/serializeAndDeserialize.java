package tricky;
import java.util.*;
public class serializeAndDeserialize {
    //Function to serialize a tree and return a list containing nodes of tree.
    // we have to serialize the tree and also deserialize the tree
    // we will store the tree in the form of level order traversal
    // we can solve this problem using two queues
    // while storing the keys, we will use the arrayList and we will use two queues to solve this problem
    // other way is to traverse the arraylist that we get and then use the queue, to add the nodes to it


    public void serialize(Node r, ArrayList<Integer> a)
    {
        //code here
        Queue<Node> que=new LinkedList<>();
        que.add(r);
        while(!que.isEmpty()){
            Node k=que.remove();
            a.add(k.data);
            if(k.data==-1){
                continue;
            }
            if(k.left!=null){
                que.add(k.left);
            }
            else{
                que.add(new Node(-1));
            }
            if(k.right!=null){
                que.add(k.right);
            }
            else{
                que.add(new Node(-1));
            }
        }
        //System.out.println(a.toString());
    }

    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> a)
    {
        //code here
        // first we will put all the nodes in the queue and then we will find the answer
        if(a.size()==0){
            return null;
        }
        Queue<Node> que=new LinkedList<>();
        Node rt=new Node(a.get(0));
        que.add(rt);
        for(int i=1;i<a.size();i++){
            Node k=que.remove();
            if(a.get(i)!=-1){
                k.left=new Node(a.get(i));
                que.add(k.left);
            }
            if(a.get(++i)!=-1){
                k.right=new Node(a.get(i));
                que.add(k.right);
            }
        }

        return rt;
    }
}

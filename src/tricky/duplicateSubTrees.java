package tricky;
import java.util.*;
public class duplicateSubTrees{

    Map<String,Integer> map=new HashMap<>();
    List<Node> result = new ArrayList<>();


    public String helper(Node root){
        if(root==null) return "";

        String left=helper(root.left);
        String right=helper(root.right);
        String curr=root.data + " " + left + " " + right;

        if(map.getOrDefault(curr,0)==1){
            result.add(root);
        }

        map.put(curr,map.getOrDefault(curr,0)+1);

        return curr;
    }

    List<Node> printAllDups(Node root) {
        helper(root);
        Collections.sort(result, (n1, n2) -> Integer.compare(n1.data, n2.data));
        return result;
    }
}
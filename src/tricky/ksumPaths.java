package tricky;

import java.util.*;


public class ksumPaths {
    public int sumK(Node root,int k)
    {
        // code here
        // we are asked to find the total paths that are present in the tree which has the sum equal to k
        // paths must be in the given subtree only and not across the subtrees in the sibling tree
        // we can use the hashmap over here and then find the answer
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        // after returning from a single branch, we have to delete the number that was added to the given element in the tree and then find the answer
        int[] ans=new int[1];
        getans(root,map,ans,0,k);

        return ans[0];

    }

    public void getans(Node root,HashMap<Integer,Integer> map,int[] ans,int sum,int k){
        if(root==null){
            return;
        }
        sum+=root.data;
        int val=sum, val1=sum-k;
        if(map.containsKey(val1)){
            ans[0]+=map.get(val1);
            map.put(val,map.getOrDefault(val,0)+1);
            getans(root.left,map,ans,sum,k);
            getans(root.right,map,ans,sum,k);
            if(map.get(val)==1){
                map.remove(val);
            }
            else{
                map.put(val,map.get(val)-1);
            }
        }
        else{
            map.put(val,map.getOrDefault(val,0)+1);
            getans(root.left,map,ans,sum,k);
            getans(root.right,map,ans,sum,k);
            if(map.get(val)==1){
                map.remove(val);
            }
            else{
                map.put(val,map.get(val)-1);
            }
        }

    }
}

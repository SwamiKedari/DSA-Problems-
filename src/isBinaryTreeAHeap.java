import java.util.*;

public class isBinaryTreeAHeap {
    boolean isHeap(treeNode tree) {
        // doubt
        // code here
        // we will use 2 queue to add and remove the elements , will keep a track of its max heap property
        Queue<treeNode> a=new LinkedList<>();
        Queue<treeNode> b=new LinkedList<>();
        a.add(tree);
        int i=1;
        return isheap(a,b,i);
    }

    boolean isheap(Queue<treeNode> a,Queue<treeNode> b,int i){
        if(i%2==1){
            if(a.size()==0){
                return true;
            }
            boolean isLeaf=false;
            while(a.size()>0){
                treeNode k=a.remove();
                if(k.left==null && k.right==null){
                    isLeaf=true;
                }
                if(k.left!=null && k.right!=null && isLeaf){
                    return false;
                }

                if(k.left!=null && k.right!=null){
                    if(k.data <k.left.data || k.data <k.right.data){
                        return false;
                    }
                    b.add(k.left);
                    b.add(k.right);
                }
                if(k.left!=null){
                    if(k.data < k.left.data){
                        return false;
                    }
                    b.add(k.left);
                }
                if(k.right!=null){
                    if(k.data < k.right.data){
                        return false;
                    }
                    b.add(k.right);
                }
            }
        }
        else{
            if(b.size()==0){
                return true;
            }
            boolean isLeaf=false;
            while(b.size()>0){
                treeNode k=b.remove();
                if(k.left==null && k.right==null){
                    isLeaf=true;
                }
                if(k.left!=null && k.right!=null && isLeaf){
                    return false;
                }

                if(k.left!=null && k.right!=null){
                    if(k.data <k.left.data || k.data <k.right.data){
                        return false;
                    }
                    a.add(k.left);
                    a.add(k.right);
                }
                if(k.left!=null){
                    if(k.data<k.left.data){
                        return false;
                    }
                    a.add(k.left);
                }
                if(k.right!=null){
                    if(k.data < k.right.data){
                        return false;
                    }
                    a.add(k.right);
                }
            }
        }
        i++;
        return isheap(a,b,i);
    }
}

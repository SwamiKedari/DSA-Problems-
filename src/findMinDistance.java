public class findMinDistance {
    // doubt
    int findDist(treeNode root, int a, int b) {
        // Your code here
        treeNode k=commonAncestor(root,a,b);
        //System.out.println(k.data);
        int val=0;
        int h=findD(k,a,0);
        //System.out.println(h);
        int kval=findD(k,b,0);

        return h+kval;
    }
    int findD(treeNode root,int a,int val){
        if(root==null){
            val=-1;
            return val;
        }
        if(root.data==a){
            return val;
        }
        int h=findD(root.left,a,val+1);
        int k=findD(root.right,a,val+1);
        if(h==-1){
            return k;
        }
        return h;


    }
    treeNode commonAncestor(treeNode root,int a,int b){
        if(root==null){
            return null;
        }
        if(root.data==a || root.data==b){
            return root;
        }
        treeNode lanc=commonAncestor(root.left,a,b);
        treeNode ranc=commonAncestor(root.right,a,b);

        if(lanc!=null && ranc!=null){
            return root;
        }
        if(lanc!=null){
            return lanc;
        }
        return ranc;
    }
}

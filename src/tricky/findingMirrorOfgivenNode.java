package tricky;

public class findingMirrorOfgivenNode {
    public int findMirror(Node root,int target)
    {
        //code here
        int[] ans=new int[1];
        ans[0]=-1;
        getans(root,root,target,ans);
        return ans[0];
    }

    public void getans(Node root1,Node root2, int t,int[] ans){
        if(root1==null || root2==null){
            return ;
        }
        if(root1.data==t){
            ans[0]=root2.data;
            return;
        }
        if(root2.data==t){
            ans[0]=root1.data;
            return;
        }

        getans(root1.left,root2.right,t,ans);
        getans(root1.right,root2.left,t,ans);

    }
}

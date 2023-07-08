package tricky;

public class minAbsoluteDifferenceInBST {
    // we can solve this type of problems in o(1) extraspace complexity by using the int array variable which will store the previous element in the inorder traversal
    // then we will take the abs difference between the cur variable and the root data
    // this will give the answer for the question
    int absolute_diff(Node root)
    {
        //Your code here
        int[] cur=new int[1];
        cur[0]=(int)1e7;
        int[] ans=new int[1];
        ans[0]=Integer.MAX_VALUE;
        getans(root,ans,cur);
        return ans[0];
    }

    void getans(Node root,int[] ans,int[] cur){
        if(root==null){
            return;
        }
        getans(root.left,ans,cur);
        ans[0]=Math.min(ans[0],Math.abs(root.data-cur[0]));
        cur[0]=root.data;
        getans(root.right,ans,cur);
    }
}

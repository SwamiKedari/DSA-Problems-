package tricky;
import java.util.*;
public class findingPairsThatViolateBSTProperty {
    /*
    The structure of the node class is:
    class Node {
    int data;
    Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    */
    // the pairs that violate the BST property will not be ordered properly in the inorder traversal
    // so we use the inorder traversal and then find the no of pairs that have a[i]>a[j] when i<j using the merge sort algorithm
    // this no will be the no of pairs that violate the BST property 

    public int mod=(int)1e9+7;

    public int pairs(Node root){
        //Write your code here
        ArrayList<Integer> ar=new ArrayList<>();
        getar(root,ar);
        int n=ar.size();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=ar.get(i);
        }
        // we will use the merge sort algorithm to get the answer
        int[] ans=new int[1];
        mergesort(a,0,n-1,ans);
        return ans[0];
    }

    public void mergesort(int[] a,int i,int j,int[] ans){
        if(i<j){
            int mid=(i+j)/2;
            mergesort(a,i,mid,ans);
            mergesort(a,mid+1,j,ans);
            merge(a,i,mid,j,ans);
        }
    }

    public void merge(int[] ar,int i,int mid,int j,int[] ans){
        int len1=mid-i+1;
        int len2=j-mid;
        int[] a=new int[len1];
        int[] b=new int[len2];
        for(int k=0;k<len1;k++){
            a[k]=ar[i+k];
        }
        for(int k=0;k<len2;k++){
            b[k]=ar[mid+k+1];
        }
        int ind1=0, ind2=0, ind3=0;
        int[] c=new int[len1+len2];
        while(ind1<len1 && ind2<len2){
            if(a[ind1]<=b[ind2]){
                c[ind3]=a[ind1];
                ind1++;
                ind3++;
            }
            else{
                c[ind3]=b[ind2];
                ind2++;
                ind3++;
                ans[0]=(ans[0]+(len1-ind1))%mod;
            }
        }
        while(ind1<len1){
            c[ind3]=a[ind1];
            ind1++;
            ind3++;
        }
        while(ind2<len2){
            c[ind3]=b[ind2];
            ind2++;
            ind3++;
        }
        for(int k=i;k<=j;k++){
            ar[k]=c[k-i];
        }
    }

    public void getar(Node root, ArrayList<Integer> ar){
        if(root==null){
            return;
        }
        getar(root.left,ar);
        ar.add(root.data);
        getar(root.right,ar);
    }

}
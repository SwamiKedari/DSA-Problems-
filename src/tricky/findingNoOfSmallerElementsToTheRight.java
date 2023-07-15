package tricky;

public class findingNoOfSmallerElementsToTheRight {
    public static int mod=(int)1e9+7;
    public static void main(String[] swami){
        int[] a={4,6,5,7,4,3,8};
        int[] ans=new int[1];
        mergesort(a,0,a.length-1,ans);
        System.out.println(ans[0]);
    }
    public static  void mergesort(int[] a,int i,int j,int[] ans){
        if(i<j){
            int mid=(i+j)/2;
            //System.out.println(i+" "+j);
            mergesort(a,i,mid,ans);
            mergesort(a,mid+1,j,ans);
            merge(a,i,mid,j,ans);
        }
    }

    public static void merge(int[] ar,int i,int mid,int j,int[] ans){
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

}

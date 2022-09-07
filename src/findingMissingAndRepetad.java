public class findingMissingAndRepetad {
    int[] findTwoElement(int a[], int n) {
        // code here
        // doubt
        int[] b=new int[2];
        for(int i=0;i<n;i++){
            int ind=Math.abs(a[i]);
            if(a[ind-1]<0){
                b[0]=ind;
            }
            else{
                a[ind-1]=-1*a[ind-1];
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]>0){
                b[1]=i+1;
                break;
            }
        }
        return b;
    }
}

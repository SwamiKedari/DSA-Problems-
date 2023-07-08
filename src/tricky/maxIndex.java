package tricky;

public class maxIndex {
    int maxIndexDiff(int a[], int n) {
        // find the smallest elements from the left
        // find the largest elements from the right
        int[] minl=new int[n];
        int[] maxr=new int[n];
        minl[0]=a[0];
        for(int i=1;i<n;i++){
            minl[i]=Math.min(minl[i-1],a[i]);
        }
        maxr[n-1]=a[n-1];
        for(int i=n-2;i>-1;i--){
            maxr[i]=Math.max(a[i],maxr[i+1]);
        }
        int i=0,j=0;
        int dif=-1;
        while(i<n && j<n){
            if(minl[i]<=maxr[j]){
                dif=Math.max(j-i,dif);
                j++;
            }
            else{
                i++;
            }
        }

        return dif;
    }
}

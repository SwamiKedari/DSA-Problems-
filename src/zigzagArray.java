public class zigzagArray {
    void zigZag(int a[], int n) {
        // code here
        boolean lessthan=true;
        for(int i=1;i<n;i++){
            if(lessthan && a[i-1]>a[i]){
                swap(a,i-1,i);
            }
            if(!lessthan && a[i-1]<a[i]){
                swap(a,i-1,i);
            }
            lessthan = !lessthan;
        }

    }
    void swap(int[] a , int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

public class rowWithMax1s {
    int rowWithMax1s(int a[][], int n, int m) {
        int c=m-1;
        int r=0;
        int h=0;
        while(true){
            if(r==n||c==-1){
                break;
            }
            int[] b=a[r];
            if(a[r][c]==1){
                c--;
                h=r;
            }
            else{
                r++;
            }

        }
        if(c==m-1){
            return -1;
        }
        return h;

    }
}

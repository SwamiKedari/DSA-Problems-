package tricky;
import java.util.*;
public class maximumTipCalculator {
    long maxTip(int[] a, int[] b, int n, int x, int y) {
        // code here
        // we are supposed to use sorting for sure
        //we will sort this problem on the basis of Math.abs(a[i]-b[i]);
        //this is because, since we will take all the n tips, we will pick up first the tips that have maximum difference between the two
        //then the tips that are remaining can be found
        int[][] val=new int[n][2];
        for(int i=0;i<n;i++){
            val[i][0]=a[i];
            val[i][1]=b[i];
        }
        Arrays.sort(val,new Comparator<int[]>(){
            public int compare(int[] a1,int[] b1){
                if(Math.abs(a1[0]-a1[1])>Math.abs(b1[0]-b1[1])){
                    return -1;
                }
                else if(Math.abs(a1[0]-a1[1])<Math.abs(b1[0]-b1[1])){
                    return 1;
                }
                return 0;
            }
        });
        long ans=0;
        for(int i=0;i<n;i++){
            if(val[i][0]>val[i][1] && x>0){
                ans+=val[i][0];
                x--;
            }
            else if(val[i][1]>val[i][0] && y>0){
                ans+=val[i][1];
                y--;
            }
            else if(x>0){
                ans+=val[i][0];
                x--;
            }
            else{
                ans+=val[i][1];
                y--;
            }
        }

        return ans;
    }
}

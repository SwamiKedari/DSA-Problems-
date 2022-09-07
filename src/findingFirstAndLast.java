import java.util.ArrayList;
import java.util.*;

public class findingFirstAndLast {
    // doubt
        public static void main(String[] args){
           Scanner s=new Scanner(System.in);
           int n=s.nextInt();
           int k=n;
           long[] a=new long[n];
           int i=0;
           while(n-->0){
               a[i]=s.nextLong();
               i++;
           }
           int r=s.nextInt();
           //System.out.println(binarySearch(a,0,k-1,r));
            int u=binarySearch(a,i,k-1,r);
            int g=u;
            int h=u;
            while(g!=-1&&g<k-1&&a[g]==a[g+1]){

                if(binarySearch(a,g+1,k-1,r)==-1){
                    break;
                }
               // g=binarySearch(a,g+1,k-1,r);

            }
            while(h!=-1&&h>0&&a[h]==a[h-1]){
                   if(binarySearch(a,i,h-1,r)==-1){
                       break;
                   }
                 // h=binarySearch(a,i,h-1,r);
                h--;
            }
            System.out.println(g+" "+h);
        }
        public static int binarySearch(long[] a,int i,int j,long k){
            int g=(i+j)/2;
            if(i>j){
                return -1;
            }
            else{
                if(a[g]==k){
                    return g;
                }
                else if(a[g]>k){
                    return binarySearch(a,i,g-1,k);
                }
                else{
                    return binarySearch(a,g+1,j,k);
                }
            }

        }
}

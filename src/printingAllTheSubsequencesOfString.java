import java.util.*;
public class printingAllTheSubsequencesOfString {
    public static void main(String[] swami){// doubt
       // System.out.println(toBinary(5,3));
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        int r=a.length();
        for(int i=1;i<Math.pow(2,r);i++){
            print(a,toBinary(i,r));
        }
    }

    public static int[] toBinary(int n,int k){
       int[] a=new int[k];
       while(--k>=0){
           a[k]=(n%2);
           n=n/2;
       }
      //System.out.println(Arrays.toString(a));
       return a;

    }

    public static void print(String x,int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]==1){
                System.out.print(x.charAt(i));
            }
        }
        System.out.println();
    }
}

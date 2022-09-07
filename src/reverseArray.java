
    import java.util.*;
    public class reverseArray{
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
            reverseAr(a,0,n-1);
            System.out.println( Arrays.toString(a));
        }
        public static void reverseAr(int[] ar,int i,int f){
            int k=ar.length;
            int r=k/2;
            if(i<r&&f>r){
                int temp=ar[i];
                ar[i]=ar[f];
                ar[f]=temp;
                reverseAr(ar,i+1,f-1);
            }

        }

    }

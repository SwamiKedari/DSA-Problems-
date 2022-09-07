
import java.util.*;


public class quickSortClass {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        quickSort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] a){
        int l=partition(a,0,a.length-1);
        partition(a,0,l);
        partition(a,l+1,a.length-1);

    }


    public static int partition(int[] a,int l,int h){
        int pivot =a[l];
        int i=l;
        int j=h;
        while(i<j){
            do{
                i++;
            }
            while(a[i]<=pivot);//finding the correct index of the  pivot element using the do while loop

            do{
                j--;
            }
            while(a[j]>pivot);
            if(i>j){
                swap(a[i],a[j]);
            }
            swap(a[i],a[j]);

        }
        return j;
    }

    public static void swap(int i,int j){
        int temp=i;
        i=j;
        j=temp;
    }


   /* public void quickSort1(int[] a,int l , int h){
        int p=h;
        int j=l;

        for(int i=l;i<h;i++){
            if(a[i]<a[p]){
                swap(a[i],a[j]);
                j++;
            }
        }
        swap(a[j],a[p]);
        p=j;
        quickSort1(a,l,p-1);
        quickSort1(a,p+1,h);
        //the time complexity of the quickSort in the worst case is O(n*n)
        //the time complexity of the quickSort can be decreased using the randomized quickSort
    }*/
}

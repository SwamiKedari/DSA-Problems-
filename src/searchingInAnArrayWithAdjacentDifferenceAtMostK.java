import java.util.*;
//program to find the index of the given number if the atmost adjacent difference between the numbers is k and the number is x
//in this case the time complexity is less than O(n)
public class searchingInAnArrayWithAdjacentDifferenceAtMostK {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int k=s.nextInt();
        int x=s.nextInt();
        System.out.println(returnIndex(a,k,x));

    }
    public static  int returnIndex(int[] a,int k,int x){
        int r=a.length;
        int f=a[0];
        int j=Math.abs((x-a[0])/k);
        for(int i=j;i<r;i++){//starting the loop from the element with index j , as j is the first element which can have the value equal to x
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
}

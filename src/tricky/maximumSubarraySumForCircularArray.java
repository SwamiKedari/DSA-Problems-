package tricky;
import java.util.*;
public class maximumSubarraySumForCircularArray {
    public static void main(String[] swami){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        // the idea is to find the kadane sum and then the maxsum that can be achieved from subarray which has the first element in it and the subarray which has the last element in it
        // the max of this two will give the answer for this question


        System.out.println(circularSubarraySum(a,n));


    }

    static int circularSubarraySum(int a[], int n) {

        // Your code here
        int[] b=new int[n];
        int[] c=new int[n];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            max=Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        sum=0;
        int kmax=max;
        max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=a[i];
            max=Math.max(sum,max);
            b[i]=max;

        }
        sum=0;
        max=Integer.MIN_VALUE;
        for(int i=n-1;i>-1;i--){
            sum+=a[i];
            max=Math.max(sum,max);
            c[i]=max;
        }
        for(int i=0;i<n-1;i++){
            kmax=Math.max(kmax,b[i]+c[i+1]);
        }
        return kmax;


    }




}

/*
*
* class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {

        // Your code here
       // we will find the kadane sum and then also find the sum from the start and the end till it becomes negative
       int max=Integer.MIN_VALUE;
       int sum=0;
       for(int i=0;i<n;i++){
           sum+=a[i];
           max=Math.max(sum,max);
           if(sum<0){
               sum=0;
           }
       }

       System.out.println(max);

       int ind=0;
       sum=0;
       int max1=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
           sum+=a[i];
           max1=Math.max(sum,max1);
           if(sum<0){
               ind=i;
               sum-=a[i];
               break;
           }
       }
       int sum1=0;
       int max2=Integer.MIN_VALUE;
       for(int i=n-1;i>-1;i--){
           sum1+=a[i];
           max2=Math.max(sum1,max2);
           if(sum1<0 || i==ind){
               break;
           }
       }

       return Math.max(max,max1+max2);
    }

}

*/

import java.util.*;
public class nextGreaterElement {
    // solution approach of this problem :https://youtu.be/rSf9vPtKcmI
    // this problem is to get the next greater element in the array based on the index
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] a=new long[n];
        Stack<Long> b=new Stack<>();
        int k=n-1;

        for(int i=n-1;i>-1;i--){
            if(b.isEmpty()){
                a[i]=-1;
                b.push(arr[i]);
            }
            else{
                while(!b.isEmpty() && b.peek() < arr[i]){
                    b.pop();
                }
                if(b.isEmpty()){
                    a[i]=-1;
                    b.push(arr[i]);
                }
                else{
                    a[i]=b.peek();
                    b.push(arr[i]);
                }
            }
        }


        return a;
    }
}

import java.util.Stack;

public class stockSpanProblem {
    //Function to calculate the span of stocks price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here
        Stack<Integer> a=new Stack<>();
        int[] b=new int[n];
        for(int i=0;i<n;i++){

            while(!a.isEmpty() && arr[i]>=arr[a.peek()]){
                a.pop();
            }
            if(!a.isEmpty()){
                b[i]=i-a.peek();
            }
            else{
                b[i]=i+1;
            }
            a.push(i);

        }
        return b;
    }
}

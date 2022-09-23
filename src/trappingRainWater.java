import java.util.*;
public class trappingRainWater {
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        // Your code here
        // We need to solve this problem similar to the method that we used in the case of the maximum rectangle in the case of the histogram
        // we will find the largest elements from the right side and push it to the stack
        // then we will take the minimum of the both the right side and the left side and then we get the trapped rain water using the difference for that particular index
        Stack<Integer> right=new Stack<>();
        Stack<Integer> left=new Stack<>();
        int[] rInd=new int[n];
        int[] lInd=new int[n];
        for(int i=0;i<n;i++){
            if(left.isEmpty()){
                lInd[i]=0;
            }
            else{
                lInd[i]=left.peek();
            }
            if(!left.isEmpty() && arr[i]>left.peek()){
                left.push(arr[i]);
            }
            else if(left.isEmpty()){
                left.push(0);
                left.push(arr[i]);
            }
        }

        for(int i=n-1;i>-1;i--){
            if(right.isEmpty()){
                rInd[i]=0;
            }
            else{
                rInd[i]=right.peek();
            }
            if(!right.isEmpty() && arr[i]>right.peek()){
                right.push(arr[i]);
            }
            else if(right.isEmpty()){
                right.push(0);
                right.push(arr[i]);
            }
        }

        // System.out.println(Arrays.toString(lInd));
        // System.out.println(Arrays.toString(rInd));

        long ans=0;

        for(int i=0;i<n;i++){
            long water=(Math.min(lInd[i],rInd[i]))-arr[i];
            if(water<0){
                water=0;
            }
            ans+=water;
        }
        return ans;




    }
}

import java.util.ArrayList;

public class subarrayWithGivenSum {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] a, int n, int s)
    {
        // Your code here
        ArrayList<Integer> b=new ArrayList<Integer>();
        int low=0, sum=0;
        int i=0;
        for(i=0;i<n;i++){
            sum+=a[i];
            System.out.println(a[low]+" "+sum+" "+s);
            if(sum>s){
                sum=sum-a[low];
                low++;
            }
            if(sum==s){
                b.add(low+1);
                b.add(i+1);
                return b;

            }
        }
        if(sum==s){
            b.add(low+1);
            b.add(i+1);
            return b;
        }
        System.out.println(sum);
        System.out.println(low);
        b.add(-1);
        return b;
    }
}

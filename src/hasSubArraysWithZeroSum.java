import java.util.HashSet;

public class hasSubArraysWithZeroSum {
    //this code is to find whether the subarray has the sum equal to zero of their elements
    //I used hashset datastructure in this question solving , considering that it has the contains function in it
    //HashSet datastructure is like map but with one element only
    static boolean findsum(int a[],int n)
    {
        //Your code here
        HashSet<Integer> b=new HashSet<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(a[i]==0||b.contains(sum)||sum==0){
                return true;
            }

            b.add(sum);
            // System.out.println(sum);

        }

        return false;
    }
}

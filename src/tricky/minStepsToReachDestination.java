package tricky;

public class minStepsToReachDestination {
    // the answer will be equal to the steps of n which will have the sum of the elements equal to n*(n+1)/2
    // the answer will be the steps if the sum of the steps - d value  is even
    // since , when the no is converted to the -no, the sum decreases by even no
    
    static int minSteps(int d){
        // code here
        int ans=0;
        int val=0,i=1;
        while(val<d){
            val+=i;
            i++;
            ans++;
        }
        //System.out.println(ans+" "+val);
        if(val==d){
            return ans;
        }

        while((val-d)%2!=0){
            val+=i;
            ans++;
            i++;
        }
        return ans;
    }
}

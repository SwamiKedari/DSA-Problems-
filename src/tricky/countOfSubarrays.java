package tricky;

public class countOfSubarrays {
    long countSubarray(int a[], int n, int k) {

        // code here
        // we are given an array of n positive integers, we r asked to find the subarray count values which are strictly greater than k
        // we will take the elements which are greater than the value k and then find the answer using this values
        // first we mark all the elements which are greater than the value k and then find the count of subarrays which lie between the two of this elements
        // the answer will be total subarrays - this no of subarrays



        boolean[] v=new boolean[n];
        for(int i=0;i<n;i++){
            if(a[i]>k){
                v[i]=true;
            }
        }

        long val=0;

        for(int i=0;i<n;i++){
            if(!v[i]){
                int j=i;
                while(j<n && !v[j]){
                    j++;
                }
                int ct=j-i;
                val+=(ct*(ct+1))/2;
                i=j-1;
            }
        }

        return ((long)n*((long)n+1))/2-val;

    }
}

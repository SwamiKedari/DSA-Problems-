public class youAndYourBooks {
    // this is an easy problem in which we have to find the maximum number of sum that we can obtain from collecting the consecutive books with heights less than or equal to k

    int max_Books(int a[], int n, int k)
    {
        // Your code here
        // this problem can be solved using the solution which is not of the recursive nature
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(a[i]<=k){
                sum+=a[i];
            }
            else{
                max=Math.max(sum,max);
                sum=0;
            }
        }
        max=Math.max(sum,max);
        return max;
    }
}

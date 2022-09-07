public class missingNumberInAnArray {
    int MissingNumber(int a[], int n) {
        int sum=0;
        for(int i=0;i<n-1;i++){
            sum+=a[i];
        }
        int total=(n*(n+1))/2;
        return total-sum;
    }
    //this function takes array and tells the missing number by difference in the total and the sum
}

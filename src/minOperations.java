public class minOperations {
    public int minOperation(int n)
    {
        //code here.
        // this is a greedy problem , the minimum number of operations required to convert the value of n to 0 will occur when we divide the number by 2 as more as possible
        // so when the number is odd , we remove 1 from it , else we always divide it by 2

        int count=0;
        while(n!=0){
            if(n%2==0){
                n=n/2;
            }
            else{
                n--;
            }
            count++;
        }
        return count;
    }
}

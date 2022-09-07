public class countSetBitsFrom1ToN {
    //Function to return sum of count of set bits in the integers from 1 to n.
    // doubt
    public static int countSetBits(int n){

        // Your code here
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }

        int p=0;
        int k=(int)Math.pow(2,p);
        while(k<=n){
            p++;
            k=(int)Math.pow(2,p);
        }
        //System.out.println(p);
        p--;
        return (int)Math.pow(2,p-1)*p+(n-(int)Math.pow(2,p)+1) + countSetBits(n-(int)Math.pow(2,p));
    }
}

import java.math.BigInteger;

public class nthCatalanNumber {
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        // we need to find the nth catalan number in the series
        BigInteger a=BigInteger.valueOf(1);
        BigInteger b=BigInteger.valueOf(1);

        if(n==0 || n==1){
            return a;
        }
        for(int i=2;i<=n;i++){
            BigInteger c=BigInteger.valueOf((4*i-2)).multiply(b).divide(BigInteger.valueOf(i+1));

            b=c;

        }
        return b;
    }
}


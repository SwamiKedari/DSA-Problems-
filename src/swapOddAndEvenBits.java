public class swapOddAndEvenBits {
    public static int swapBits(int n)
    {
        // Your code
        int a=n&(0xAAAAAAAA); //this will give alternate 10 starting with 1
        int b=n&(0x55555555); // this will give alternate 01 starting with 0
        a>>=1;
        b<<=1;

        return a|b;
    }

}

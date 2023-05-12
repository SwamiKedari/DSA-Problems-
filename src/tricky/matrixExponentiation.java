package tricky;

public class matrixExponentiation {
    // using matrix exponentiation to find the fibonacci number in logn time,
    // the matrix exponentiation is same as the binary exponentiation just that it is applied on the matrix
    // the matrix for the fibonacci number can be expressed in the form [f(n) f(n+1)][f(n+1) f(n)] =[1 1][1 0] raise to n
    // using this formula, we can get the fibonacci number using the logn time
    
    public int mod=(int)1e9+7;
    public int countStrings(long n) {
        // Code here
        long[][] a=new long[2][2];
        a[0][0]=1;
        a[0][1]=1;
        a[1][0]=1;
        long[][] b=exponentiation(a,n+1);

        // System.out.println(b[0][0]+" "+b[0][1]);
        // System.out.println(b[1][0]+" "+b[1][1]);
        return (int)b[0][0]%mod;
    }

    public long[][] mult(long[][] a,long[][] b){
        long[][] c=new long[2][2];
        c[0][0]=((a[0][0]*b[0][0])%mod+(a[0][1]*b[1][0])%mod)%mod;
        c[0][1]=((a[0][0]*b[0][1])%mod+(a[0][1]*b[1][1])%mod)%mod;
        c[1][0]=((a[1][0]*b[0][0])%mod+(a[1][1]*b[1][0])%mod)%mod;
        c[1][1]=((a[1][0]*b[0][1])%mod+(a[1][1]*b[1][1])%mod)%mod;
        // System.out.println(c[0][0]+" "+c[0][1]);
        // System.out.println(c[1][0]+" "+c[1][1]);
        // System.out.println();


        return c;
    }

    public long[][] exponentiation(long[][] a,long n){
        if(n==0){
            long[][] mat=new long[2][2];
            mat[0][0]=1;
            mat[1][1]=1;
            return mat;
        }
        if(n==1){
            return a;
        }
        long[][] div1=exponentiation(a,n/2);
        long[][] mult1=mult(div1,div1);

        if(n%2==1){
            mult1=mult(a,mult1);
        }
        return mult1;
    }
}
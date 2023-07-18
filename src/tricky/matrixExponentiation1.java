package tricky;

public class matrixExponentiation1 {
    public int mod=(int)1e9+7;
    public int FindNthTerm(int n)
    {
        // code here
        // we will have to use the formula for the matrix exponentiation to solve this problem
        // the code for the matrix exponentiation is very similar to  the code of binary exponentiation, we will use it
        if(n==1){
            return 1;
        }
        if(n==0){
            return 1;
        }

        long[][] a=new long[2][2];
        a[0][0]=1l; a[1][0]=1l; a[0][1]=1l;
        long[][] f=matExp(a,n-1);
        return (int)(f[0][0]+f[0][1])%mod;
    }

    public long[][] matExp(long[][] a,int n){
        if(n==1 || n==0){
            return a;
        }
        long[][] val=matExp(a,n/2);
        val=mult(val,val);
        if(n%2==0){
            return val;
        }
        else{
            return mult(val,a);
        }
    }

    public long[][] mult(long[][] a,long[][] b){
        long[][] c=new long[2][2];
        c[0][0]=((a[0][0]*b[0][0])%mod+(a[0][1]*b[1][0])%mod)%mod;
        c[0][1]=((a[0][0]*b[0][1])%mod+(a[0][1]*b[1][1])%mod)%mod;
        c[1][0]=((a[1][0]*b[0][0])%mod+(a[1][1]*b[1][0])%mod)%mod;
        c[1][1]=((a[1][0]*b[0][1])%mod+(a[1][1]*b[1][1])%mod)%mod;
        return c;
    }
}

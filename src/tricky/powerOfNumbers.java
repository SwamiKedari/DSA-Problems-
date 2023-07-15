package tricky;

public class powerOfNumbers {
    //finding the powers of any no to the other no using the binary exponentiation

    long power(int n,int r)
    {
        //Your code here
        if(n==0){
            return 0;
        }
        if(r==1){
            return n;
        }
        if(r==0){
            return 1;
        }
        long mod=(long)1e9+7;
        long val=power(n,r/2)%mod;
        long ans=0;
        if(r%2==0){
            ans=(((val)%mod)*((val)%mod))%mod;
        }
        else{
            ans=((((val)%mod)*((val)%mod))%mod*n)%mod;
        }
        return ans;
    }

}

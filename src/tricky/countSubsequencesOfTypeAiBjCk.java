package tricky;

public class countSubsequencesOfTypeAiBjCk {
    // after appending a value to the previous values , the subsequences generated are as mentioned in this article:

    // https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
    public long mod=(long)1e9+7;
    public long fun(String s)
    {
        long a=0,b=0,c=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                a=(2*a+1)%mod;
            }
            else if(ch=='b'){
                b=(2*b+a)%mod;
            }
            else{
                c=(2*c+b)%mod;
            }
        }

        return c%mod;
    }
}

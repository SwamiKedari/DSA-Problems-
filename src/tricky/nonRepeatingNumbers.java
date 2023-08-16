package tricky;

public class nonRepeatingNumbers {
    public int[] singleNumber(int[] a)
    {
        // Code here
        // we will take the xor of all the elements
        // this will give the answer of the xor of the distinct elements
        // then we will divide the array into two parts based on the first indice where the two numbers differ
        // this will give us the answer
        // logic: just we need to divide the xor of two numbers that we get, this is done by finding the first index where both of the elements differ in their indexes
        // then after we find that index in the bit representation, we will consider two variables for ans1 and ans2
        // this will give the answer as the two numbers have that bit different
        
        int xor=0, n=a.length;
        for(int i=0;i<n;i++){
            xor^=a[i];
        }
        int ind=0;
        while(xor%2!=1){
            xor/=2;
            ind++;
        }

        int xor1=0, xor2=0;
        for(int i=0;i<n;i++){
            if((a[i]&(int)Math.pow(2,ind))==0){
                xor1^=a[i];
            }
            else{
                xor2^=a[i];
            }
        }

        int[] ans=new int[2];
        int max=Math.max(xor1,xor2);
        int min=Math.min(xor1,xor2);
        ans[0]=min; ans[1]=max;
        return ans;
    }
}

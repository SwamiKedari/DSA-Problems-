public class minimumCoins {
    public int MinCoin(int[] a, int t)
    {
        // Code here
        // we need to find the minimum number of coins which will be required to get the target value
        // check this question in the dynamic programming in intellij
        int n=a.length;
        int[] prev=new int[t+1];
        int[] curr=new int[t+1];
        for(int i=0;i<=t;i++){
            if(i%a[0]==0){
                prev[i]=i/a[0];
            }
            else{
                prev[i]=(int)Math.pow(10,9);
            }
        }

        for(int i=1;i<n;i++){
            for(int k=0;k<=t;k++){
                int notTake=prev[k];
                int take=(int)Math.pow(10,9);
                if(k>=a[i]){
                    take=curr[k-a[i]]+1;
                }
                curr[k]=Math.min(take,notTake);
            }
            prev=curr;
            curr=new int[t+1];
        }
        if(prev[t]!=1000000000){
            return prev[t];
        }
        return -1;

    }
    // we use the below code as a template for the iterative tabulation and space optimization code
    public int getMin(int[] a ,int i,int t){
        if(i==0){
            if(t%a[i]==0){
                return t/a[i];
            }
            return (int)Math.pow(10,9);
        }
        int notTake=getMin(a,i-1,t);
        int take=(int)Math.pow(10,9);
        if(t>=a[i]){
            take=getMin(a,i,t-a[i])+1;
        }
        return Math.min(take,notTake);
    }
}

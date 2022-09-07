public class coinChange {
    public long count(int[] a,int n,int t) {
        // code here.
        // we will use dynamic programming problem minimum coins which we used in the dp project in intellij
        // the answer for this question will be the space optimised solution
        long[] prev=new long[t+1];
        long[] curr=new long[t+1];
        for(int i=0;i<=t;i++){
            if(i%a[0]==0){
                prev[i]=1;
            }
        }

        for(int i=1;i<n;i++){
            for(int k=0;k<=t;k++){
                long notTake=prev[k];
                long take=0;
                if(k>=a[i]){
                    take=curr[k-a[i]];
                }
                curr[k]=take+notTake;
            }

            curr=new long[t+1];
        }

        return prev[t];

    }
    public long getTotal(int[] a,int i,int t){
        if(i==0){
            if(t%a[i]==0){
                return 1;
            }
            return 0;
        }

        long notTake=getTotal(a,i-1,t);
        long take=0;
        if(t>=a[i]){
            take=getTotal(a,i,t-a[i])+1;
        }
        return take+notTake;
    }
}

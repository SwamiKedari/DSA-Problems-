package tricky;

public class templeOfferings {
    int offerings(int n,int[] a){
        // code here
        // we have to find the total no of offerings that will be required for the temples
        // we will store the longest increasing subarray and longest decreasing subarray and then take the max of both of them for each index
        // this will give the answer
        int[] suf=new int[n];
        int[] pr=new int[n];
        pr[0]=1;
        for(int i=1;i<n;i++){
            if(a[i]>a[i-1]){
                pr[i]=pr[i-1]+1;
            }
            else{
                pr[i]=1;
            }
        }

        suf[n-1]=1;
        for(int i=n-2;i>-1;i--){
            if(a[i]>a[i+1]){
                suf[i]=suf[i+1]+1;
            }
            else{
                suf[i]=1;
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(suf[i],pr[i]);
        }
        return ans;

    }
}

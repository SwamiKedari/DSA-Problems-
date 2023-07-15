package tricky;

public class findSmallestGCDSubarray {
    // smallest gcd can be of size 1 or 2 if present
    // else it will return -1
    int findSmallestSubArr(int[] arr, int n, int g) {
        // code here
        int ans=-1;
        for(int i=0;i<n-1;i++){
            if(gcd(arr[i],arr[i+1])==g){
                ans=2;
            }

        }
        for(int i=0;i<n;i++){
            if(g==arr[i]){
                ans=1;
            }
        }
        return ans;
    }
    int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}

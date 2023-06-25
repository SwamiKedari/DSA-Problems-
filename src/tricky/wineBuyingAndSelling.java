package tricky;

public class wineBuyingAndSelling {
    long wineSelling(int[] a,int n){
        // code here
        // we have to keep two pointers one for buying and one for selling
        // then we have to move this pointers and get the answer
        // this is the greedy approach which will give the min answer we are greedily taking the closest value from the value of the buying and selling houses
        // this will give the answer
        long ans=0;
        int s=0, b=0;
        for(int i=0;i<n;i++){
            if(a[i]>0){
                b=i;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]<0){
                s=i;
                break;
            }
        }

        while(s<n && b<n){
            //int k=a[s], k1=a[b];
            if(Math.abs(a[s])<Math.abs(a[b])){
                a[b]-=Math.abs(a[s]);
                ans+=Math.abs(s-b)*Math.abs(a[s]);
                a[s]=0;
                while(s<n && a[s]>=0){
                    s++;
                }
            }
            else if(Math.abs(a[s])>Math.abs(a[b])){

                ans+=Math.abs(s-b)*Math.abs(a[b]);

                a[s]+=a[b];
                a[b]=0;
                while(b<n && a[b]<=0){
                    b++;
                }
            }
            else{
                ans+=Math.abs(s-b)*Math.abs(a[b]);
                a[b]=0;
                a[s]=0;
                while(b<n && a[b]<=0){
                    b++;
                }
                while(s<n && a[s]>=0){
                    s++;
                }
            }
        }

        return ans;
    }
}

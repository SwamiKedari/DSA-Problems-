//finding the missing and the repeated elements of the array using swap sort
//this questions has time complexity o(n)
//also the space complexity should be o(1)

class swapsort {
    int[] findTwoElement(int a[], int n) {
        // code here
        // doubt
        int[] b=new int[2];
        int i=0;
        while(i<n){
            if(a[i]==i+1){
                i++;
            }
            else{
                int k=a[i];
                if(a[k-1]==k){
                    i++;
                    continue;
                }
                int r=a[k-1];
                a[k-1]=k;
                a[i]=r;
            }
        }
        for(int yu=0;yu<n;yu++){
            if(a[yu]!=yu+1){
                b[0]=a[yu];
                b[1]=yu+1;
            }
        }


        return b;
    }
}

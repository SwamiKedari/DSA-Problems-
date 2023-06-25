package tricky;

public class policeAndThieves {
    static int catchThieves(char a[], int n, int k)
    {
        // Code here
        // we have to find the total number of thiefs that can be caught using the police
        // this question is very similar to the wine buying and selling problem, where we use two problems for p and s
        // and then solve the problem
        
        int ans=0;
        int p=-1, t=-1;
        for(int i=0;i<n;i++){
            if(a[i]=='P'){
                p=i;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(a[i]=='T'){
                t=i;
                break;
            }
        }
        if(p==-1 || t==-1){
            return 0;
        }
        while(p<n && t<n){
            int dist=Math.abs(p-t);
            if(dist<=k){
                ans++;
                a[t]='c';
                while(t<n && a[t]!='T'){
                    t++;
                }
                a[p]='i';
                while(p<n && a[p]!='P'){
                    p++;
                }
            }
            else{
                if(p<t){
                    a[p]='i';
                    while(p<n && a[p]!='P'){
                        p++;
                    }
                }
                else{
                    a[t]='c';
                    while(t<n && a[t]!='T'){
                        t++;
                    }
                }
            }

        }

        return ans;
    }
}

package tricky;

public class shortestPathBetweenCities {
    int shortestPath( int x, int y){
        // code here
        // we are given with two values of x and y, we need to find the value of distance between them
        // first we will make both x and y reach the same level by dividing them by levels multiplied by two
        // then we will find the common root between both of them and for this at each step the distance will increase by two
        // thus the total answer can be found in log(max(x,y))
        int ct=0, ct1=0;
        int m=x,n=y;
        while(m!=0){
            m/=2;
            ct++;
        }
        while(n!=0){
            n/=2;
            ct1++;
        }
        int ans=0;
        if(ct>ct1){
            int k=ct-ct1;
            x/=Math.pow(2,k);
            ans=k;
        }
        else if(ct<ct1){
            int k=ct1-ct;
            y/=Math.pow(2,k);
            ans=k;
        }
        //System.out.println(ans);
        while(x!=y){
            x/=2;
            y/=2;
            ans+=2;
        }
        return ans;

    }
}

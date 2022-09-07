public class shortestPathFrom1toN {
    static int minStep(int n){
        //complete the function here
        // we will move in the reverse order , if we find that the value of n is multiple of 3 , we will divide it by 3
        // else we will add the modulus and remove it from n
        // we will reach to 1 in this order
        // this will give the minimum edges
        int count=0;
        int k=n;
        while(n>2){
            if(n%3==0){
                n=n/3;
                count++;
            }
            else{
                int k1=n%3;
                count+=k1;
                n-=k1;
            }
            //System.out.println(n);
        }
        count+=n-1;

        return count;
    }
}

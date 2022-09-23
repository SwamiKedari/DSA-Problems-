public class totalSquaresInTheMatrix {
    static long squaresInMatrix(int m, int n) {
        // code here
        // the question is an easy maths problem , in this the total number of squares will be m*n, m-1*n-1 and so on till the value of m or n is not equal to zero
        long ans=0;
        while(m!=0 && n!=0){
            ans+=m*n;
            m--;
            n--;
        }
        return ans;
    }
}

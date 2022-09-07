public class jumpGame {
    static int canReach(int[] a,int n) {
        // code here
        // this is
        // we need to find out whether the man can jump from the start to the end
        // we will solve this question in the same way we solved the min jumps problem
        int max=0 ;
        int maxI=0;
        int ind=0 , steps=0 ,jump=0;
        if(a[0]==0){
            return 0;
        }
        if(n==1){
            return 1 ;
        }
        int loopCount=0;
        // we use a loopCount variable which will help in case any case tries to convert the while loop to infinite loop
        while(ind<n){
            if(loopCount>100){
                return 0;
            }
            steps=a[ind];
            //System.out.println(steps);
            //System.out.println(ind+"**");
            for(int k=1;k<=steps;k++){
                if(k+ind>=n-1){
                    return 1;
                }
                if(max<k+a[k+ind]){
                    max=k+a[k+ind];
                    maxI=ind+k;
                }
            }
            ind=maxI;
            max=0;
            if(a[maxI]==0){
                return 0;
            }
            loopCount++;
        }
        return 1;
    }
}

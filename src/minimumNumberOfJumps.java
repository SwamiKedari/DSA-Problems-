public class minimumNumberOfJumps {
    // we will see the most cost effective indexes which we can land so that it will reach to the farthest from the array after we add the max jump from that index
    //

    static int minJumps(int[] arr){
        // your code here
        // we will use  greedy approach to solve this problem
        /* the logic :
        we will keep a track of what is the maximum index ahead one can reach from the available options
        this max steps will be from the last index from where the jump was taken
        */

        int steps = 0;
        int count=0;
        int i=0;
        int len=arr.length;
        if(len==1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }

        int tlimit=0;
        while(i<len){
            int h=arr[i];
            int j=0;
            int max=0 , maxInd=0;
            for(j=i+1;j<len&& j<=h+i;j++ ){
                steps++;
                if(steps+arr[j] >max){
                    max=steps+arr[j];
                    maxInd=j;
                }
            }
            steps = maxInd;
            //System.out.println(maxInd);
            if(j==len){
                count++;
                return count;
            }
            count++;
            //steps=0;
            i=maxInd;
            tlimit++;
            if(tlimit==1000){
                return -1;
            }
        }

        return count;

    }
}

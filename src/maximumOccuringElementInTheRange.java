public class maximumOccuringElementInTheRange {
    //Function to find the maximum occurred integer in all ranges.
    // doubt
    public static int maxOccured(int[] l,int[] r,int n,int max){
        // https://practice.geeksforgeeks.org/problems/maximum-occured-integer4602/1/?page=1&difficulty[]=0&status[]=unsolved&sortBy=submissions#
        // we have to find the integer which occured the most in the array
        // the algorithm for the question is as follows
        // make a array of size max+1
        // in this array , increment the value at index li by 1
        // decrement the value at index ri+1 by 1
        // use another array which will contain the prefix sum
        // prefix sum array will have the value from start to end
        // it will update its value based on the next in the array of size max
        //System.out.println(max);
        int[] a=new int[max+2];
        for(int i=0;i<n;i++){
            a[l[i]]++;
            a[r[i]+1]--;
        }

        for(int i=1;i<max+2;i++){


            a[i]+=a[i-1];
        }

        //System.out.println(Arrays.toString(a));
        int max1=a[0];
        int maxInd=0;
        for(int i=1;i<max+2;i++){
            if(a[i]>max1){
                max1=a[i];
                maxInd=i;
            }
        }

        return maxInd;
    }
}

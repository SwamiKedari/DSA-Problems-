public class minSwapsAndKTogether {
    // Function for finding maximum and value pair
    public static int minSwap (int a[], int n, int k) {// doubt
        //Complete the function
        //count all the elements of the array which have value greater than or equal to k
        //then use sliding window to keep a track of elements in this range from left to right and then get the window when the array has greatest number of no less than k
        //https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1/?page=4&difficulty[]=1&sortBy=submissions#

        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]<=k){
                count++;
            }
        }

        int swcount=0;
        for(int i=0;i<count;i++){
            if(a[i]<=k){
                swcount++;
            }
        }
        int max=swcount;

        for(int i=count;i<n;i++){
            if(a[i-count]<=k){
                swcount--;
            }
            if(a[i]<=k){
                swcount++;
            }
            if(max<swcount){
                max=swcount;
            }
        }


        return count-max;
    }
}

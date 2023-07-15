package tricky;

public class findingSecondSmallestElementInTheArray {
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Your code here
        for(int i=0;i<n;i++){
            if(arr[i]<=0){
                arr[i]=(int)1e7;
            }
        }

        for(int i=0;i<n;i++){
            if(Math.abs(arr[i])!=(int)1e7){
                int ind=Math.abs(arr[i])-1;
                if(ind>=0 && ind<n && arr[ind]>0){
                    //System.out.println(ind);
                    arr[ind]=-1*arr[ind];
                }
            }
        }
        //System.out.println(Arrays.toString(arr));

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                return i+1;
            }
        }

        return n+1;
    }
}

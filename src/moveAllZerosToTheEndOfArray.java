public class moveAllZerosToTheEndOfArray {
    void pushZerosToEnd(int[] arr, int n) {
        // doubt
        // code here
        // we have to move the zeros to the end in the array
        // we use two pointers to solve this problem
        int i=0 , j=0;
        while(arr[i]!=0){
            i++;
            if(i==n){
                return;
            }
        }
        j=i;
        while(j<n){
            while(arr[j]==0){
                j++;
                if(j==n){
                    return;
                }
            }
            swap(arr,i,j);
            while(i<n && arr[i]!=0){
                i++;
            }
        }



    }

    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

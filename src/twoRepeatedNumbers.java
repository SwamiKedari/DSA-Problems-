public class twoRepeatedNumbers {
    // we will use the array elements as the indexes of the elements and then we will change the elements at that indexes to negative , if we found that an element is already negative then we will consider it as the repeating element , else we will not

    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        int[] a=new int[2];
        int i=0;
        for(int j=0;j<n+2;j++){
            int k=Math.abs(arr[j]);
            //System.out.println(k);
            if(arr[k]<0){
                a[i]=Math.abs(arr[j]);
                i++;
            }
            else{
                arr[k]*=-1;
            }
        }

        return a;
    }
}

public class nonRepeatingNumbers {
    public int[] singleNumber(int[] nums)
    {
        // doubt
        // Code here
        int k=0;
        for(int i=0;i<nums.length;i++){
            k^=nums[i];
        }
        int sum=k;
        // now the sum will have the values of xor of the two different numbers
        // so we find the rightmost bit of it and we do this to take the separate xor for the different numbers to get the different numbers

        int[] a=new int[2];
        sum=sum&(-sum);
        for(int i=0;i<nums.length;i++){
            System.out.println(sum&nums[i]);
            if((sum&nums[i])>0){
                a[0]=a[0]^nums[i];
            }
            else{
                a[1]=a[1]^nums[i];
            }
        }
        if(a[0]>a[1]){
            int temp=a[0];
            a[0]=a[1];
            a[1]=temp;
        }
        return a;
    }
}

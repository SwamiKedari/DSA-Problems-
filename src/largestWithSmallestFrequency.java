import java.util.HashMap;

public class largestWithSmallestFrequency {
    // doubt
    //we use hashmaps to get the largest number in the array with the smallest frequency
    //this is done in the following way
    public static int LargButMinFreq(int a[], int n) {
        // Your code here
        HashMap<Integer,Integer> b=new HashMap<>();
        int k=a.length;
        //int count=0;
        int large=0;
        int min=1;
        for(int i=0;i<k;i++){
            if(b.containsKey(a[i])){
                b.put(a[i],b.get(a[i])+1);
                //System.out.println(a[i]);
            }
            else{
                b.put(a[i],1);
            }
        }

        for(int i=0;i<k;i++){
            if(b.get(a[i])<=min&&large<a[i]){
                min=b.get(a[i]);
                large=a[i];
            }
        }
        return large;

    }
}

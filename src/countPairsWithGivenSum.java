import java.util.HashMap;

public class countPairsWithGivenSum {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer,Integer> a=new HashMap<>();
        for(int i=0;i<n;i++){
            if(a.containsKey(arr[i])){
                a.put(arr[i],a.get(arr[i])+1);
            }
            else{
                a.put(arr[i],1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            int h=k-arr[i];
            if(a.containsKey(h)){

                count+=a.get(h);
            }
            if(h==arr[i]){
                count--; // when the value of h will be equal to arr[i] , it will not be the pair but just the single element hence we need to decrease the count variable by 1

            }
        }
        return count/2;
    }
}

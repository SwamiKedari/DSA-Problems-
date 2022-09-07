import java.util.*;
//in this question , we used the map to find the second most frequent element in a string array
//question no.84 of the final 450
public class findingSecondMostFrequentElementInArray {
    String secFrequent(String a[], int n)
    {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put(a[0],1);
        for(int i=1;i<n;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],1);

            }
            else{
                map.put(a[i],map.get(a[i])+1);
            }
        }

        int k=0;
        String v=null;
        for(int i=0;i<n;i++){
            if(map.get(a[i])>k){
                k=map.get(a[i]);


            }
        }
        // System.out.println(k);
        int h=0;
        for(int i=0;i<n;i++){
            if(map.get(a[i])!=k&&map.get(a[i])>h){
                h=map.get(a[i]);
                v=a[i];
            }
        }
        return v;


    }
}

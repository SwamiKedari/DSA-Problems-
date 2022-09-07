import java.util.*;

public class secFrequentInStringArray {
    String secFrequent(String[] a,int n)
    {
        // your code here
        HashMap<String,Integer> b=new HashMap<>();
        for(int i=0;i<n;i++){
            if(b.containsKey(a[i])){
                b.put(a[i],b.get(a[i])+1);
            }
            else{
                b.put(a[i],1);
            }
        }
        int max=0;
        for(Map.Entry v : b.entrySet()){
            int h=(int)v.getValue();
            if(h>max){
                max=h;
            }
        }

        String maxString="";
        int max1=0;
        for(Map.Entry v : b.entrySet()){
            int h=(int)v.getValue();
            if(max1<h && h<max){
                maxString=(String) v.getKey();
                max1=h;
            }
        }

        return maxString;
    }
}

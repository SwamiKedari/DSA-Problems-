import java.util.*;
public class substringOfLengthkWithkminus1Distinctcharacters {
    static int countOfSubstrings(String s,int k) {
// code here
// we will have the hashmap and the sliding window
// we will add the new characters and decrease the previous characters from the hashmap
// if the size of the hashmap is k-1, then we get the answer
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        if(n<k){
            return 0;
        }

        int st=0;
        for(int i=0;i<k;i++){
            char b=s.charAt(i);
            if(map.containsKey(b)){
                map.put(b,map.get(b)+1);
            }
            else{
                map.put(b,1);
            }
        }
        int count=0;

        if(map.size()==k-1){
            count++;
        }
        int j=0;
        for(int h=k;h<n;h++){
            char b=s.charAt(h);
            if(map.containsKey(b)){
                map.put(b,map.get(b)+1);
            }
            else{
                map.put(b,1);
            }
            char pr=s.charAt(j);
            if(map.get(pr)>1){
                map.put(pr,map.get(pr)-1);
            }
            else{
                map.remove(pr);
            }
            if(map.size()==k-1){
                count++;
            }
            j++;
        }
        return count;

    }
}

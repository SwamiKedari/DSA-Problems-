import java.util.HashMap;

public class checkIfStringIsRepetitionOfKUnits {
    //we used map to check if the string can be formed by replacing atmost one substring part by another substring
    //this we did using the following code


    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here
        if(n%k!=0){
            return 0;
        }
        HashMap<String,Integer> a=new HashMap<>();
        for(int i=0;i<n;i+=k){
            if(a.containsKey(s.substring(i,i+k))){
                a.put(s.substring(i,i+k),a.get(s.substring(i,i+k)+1));
            }
            else{
                a.put(s.substring(i,i+k),1);
            }
        }
        if(a.size()==2){
            return 1;
        }
        if(a.size()==1){
            return 1;
        }
        return 0;
    }
}

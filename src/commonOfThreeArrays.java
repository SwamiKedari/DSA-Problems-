
import java.util.*;
//User function Template for Java

class commonOfThreeArrays
{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3)
    {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> v=new ArrayList<Integer>();
        for(int i=0;i<n1;i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);

            }
            else{
                map.put(a[i],map.get(1));
            }
        }
        for(int i=0;i<n2;i++){
            if(map.containsKey(b[i])){
                map.put(b[i],map.get(b[i])+1);

            }

        }
        for(int i=0;i<n3;i++){
            if(map.containsKey(c[i])){
                map.put(c[i],map.get(c[i])+1);
                if(map.get(c[i])>=3){
                    v.add(c[i]);
                }

            }

        }
        System.out.println(v.size()+1);
        return v;

    }
}
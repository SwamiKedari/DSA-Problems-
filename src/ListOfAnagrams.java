import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfAnagrams {
    // doubt
        public List<List<String>> Anagrams(String[] s) {
            // Code here
            List<List<String>> a=new ArrayList<>();
            List<String> a1=new ArrayList<>();
            a1.add(s[0]);
            a.add(a1);
            int n=s.length;
            int j=0;
            for(int i=1;i<n;i++){
                for( j=0;j<a.size();j++){
                    if(isAna(a.get(j).get(0),s[i])){
                        a.get(j).add(s[i]);
                        break;
                    }

                }
                if(j!=a.size()){
                    continue;
                }
                ArrayList<String> a2=new ArrayList<>();
                a2.add(s[i]);
                a.add(a2);
            }
            return a;


        }
        private boolean isAna(String a,String b){
            char[] v=a.toCharArray();
            char[] f=b.toCharArray();
            Arrays.sort(v);
            Arrays.sort(f);
            return Arrays.equals(v,f);
        }
    }



import java.util.ArrayList;
// doubt
public class lookAndSay {
    static String lookandsay(int n) {
        //your code here
        // you can check this nice question at https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1/?page=3&difficulty[]=0&curated[]=7&sortBy=submissions#

        String a="1";
        for(int i=1;i<n;i++){
            a=getCount(a);
            //System.out.println(a);
        }
        return a;
    }

    static String getCount(String a){
        ArrayList<Integer> b=new ArrayList<>();
        int k=a.length();
        if(a.equals("1")){
            return "11";
        }
        int t=1;
        for(int i=1;i<k;i++){
            if(a.charAt(i)!=a.charAt(i-1)){
                b.add(t);
                if(i==k-1){
                    b.add(1);
                }
                t=1;
            }
            else{
                t++;
                if(i==k-1){
                    b.add(t);
                }
            }
        }
        StringBuilder c=new StringBuilder();
        int h=b.size();
        int j=0;
        for(int i=0;i<h;i++){
            c.append(b.get(i));
            c.append(a.charAt(j));
            j+=b.get(i);
        }
        //System.out.println(c.toString());
        return c.toString();
    }
}

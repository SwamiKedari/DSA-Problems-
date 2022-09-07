import java.util.ArrayList;

public class segmentOfDictionary {
    public static int wordBreak(String a, ArrayList<String> b )
    {
        if(canForm(a,b)||canForm1(a,b)){
            return 1;
        }
        else{
            return 0;
        }

    }
    private static boolean canForm(String a,ArrayList<String> c){
        int n=a.length();
        if(contains(a,c)){
            return true;
        }
        for(int i=0;i<n;i++){
            String pre=a.substring(0,n-i);
            String pos=a.substring(n-i,n);
            if(contains(pre,c)&&contains(pos,c)){
                return true;
            }
            else if(contains(pre,c)){
                //System.out.println(pre+" "+pos);
                return canForm(pos,c);
            }}
        return false;

    }

    private static boolean canForm1(String a,ArrayList<String> c){
        int n=a.length();
        if(contains(a,c)){
            return true;
        }
        for(int i=1;i<n;i++){
            String pre=a.substring(0,i);
            String pos=a.substring(i,n);
            if(contains(pre,c)&&contains(pos,c)){
                return true;
            }
            else if(contains(pre,c)){
                //System.out.println(pre+" "+pos);
                return canForm(pos,c);
            }}
        return false;

    }
    private static boolean contains(String a,ArrayList<String> b){
        for(String c:b){
            if(c.equals(a)){
                return true;
            }
        }
        return false;
    }
}

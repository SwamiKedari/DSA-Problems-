import java.util.*;

public class test {

    public static void main(String[] swami){
        ArrayList<String> ans=removeInvalidParentheses("d(((p)((x(");
        System.out.println(String.valueOf(ans));
    }

    public static ArrayList<String> removeInvalidParentheses(String s) {
        // code here
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }
            else if(ch==')'){
                st.push(ch);
            }
        }

        int len=n-st.size(); // this will be the length of the maximum characters that present in the valid string balanced
        System.out.println(len);
        System.out.println(String.valueOf(st));
        ArrayList<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        addtolist(set,s,0,"",n,len);
        for(String string: set){
            ans.add(string) ;
        }

        Collections.sort(ans);
        return ans;
    }

    public static void addtolist(HashSet<String> ar,String s,int i,String val,int n,int min){
        if(i==n){
            if(val.length()==min){
                if(check(val)){
                    ar.add(val);
                }
            }
            return;
        }

        addtolist(ar,s,i+1,val+s.charAt(i),n,min);
        addtolist(ar,s,i+1,val,n,min);
    }

    public static boolean check(String s){
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }

        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}

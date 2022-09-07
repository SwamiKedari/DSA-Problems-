import java.util.Stack;

public class validSubstring {
    static int findMaxLen(String s) {
        // code here
        // this problem is important and gives the longest valid substring of the string
        Stack<Integer> a=new Stack<>();
        a.push(-1);
        int k=s.length();
        int result=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='('){
                a.push(i);
            }
            else{

                if(!a.isEmpty()){
                    a.pop();
                    if(!a.isEmpty()){
                        result=Math.max(result,i-a.peek());
                    }
                    else{
                        a.push(i);
                    }


                }}}
        return result;
    }
}

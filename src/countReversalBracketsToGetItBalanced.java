import java.util.Stack;

public class countReversalBracketsToGetItBalanced {
    // doubt
    int countRev (String a)
    {
        // your code here
        if(a.length()%2!=0){
            return -1;
        }
        int k=a.length();
        Stack<Character> s=new Stack<>();
        for(int i=0;i<k;i++){
            if(a.charAt(i)=='}'&&!s.isEmpty()){
                if(s.peek()=='{'){
                    s.pop();
                }
                else{
                    s.push('}');
                }
            }
            else{
                s.push(a.charAt(i));
            }
        }
        int n=0;
        //System.out.println(s.size());
        k=s.size();
        while(!s.isEmpty()){
            char v=s.peek();
            s.pop();
            n++;
            if(!s.isEmpty()&&v!=s.peek()){
                break;
            }

        }
        // System.out.println(s.size());
        return k/2+n%2;
    }
}

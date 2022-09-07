import java.util.*;

public class paranthesis {
    static boolean ispar(String x)
    {
        // add your code here
        if(x.length()%2!=0){
            return false;
        }
        String a="{[(";
        String b="}])";
        Stack<Character> c=new Stack<>();
        for(int i=0;i<x.length();i++){

            if(a.indexOf(x.charAt(i))!=-1){
                c.push(x.charAt(i));}
            else{
                if(c.empty()){
                    return false;
                }
                if(b.indexOf(x.charAt(i))==a.indexOf(c.peek())){

                    c.pop();

                }
                else{
                    return false;
                }
            }
        }
        if(c.empty()){
            return true;
        }
        return false;
    }
}

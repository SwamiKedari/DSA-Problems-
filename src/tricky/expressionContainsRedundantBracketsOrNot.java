package tricky;
import java.util.*;
public class expressionContainsRedundantBracketsOrNot {
    public static int checkRedundancy(String s) {
        // code here
        // we are asked to find the redundant brackets are present or not in the list
        // both the parenthesis that are inserted and removed must have the same adjacent order in the insertion list
        // also the '(' must be followed by atleast one operator sign before the ')'
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int ans=0;
        int wantplus=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
                wantplus=1;
            }
            else if(ch==')'){
                if(wantplus==1){
                    ans=1;
                }
                int j=i+1;
                int k=st.pop();
                while(j<n && s.charAt(j)==')'){
                    int val=st.pop();
                    if(val==k-1){
                        ans=1;
                    }
                    k=val;
                    j++;
                }
                i=j-1;
            }
            else if(ch=='+' || ch=='*' || ch=='/' || ch=='-'){
                wantplus=0;
            }
        }

        return ans;
    }
}

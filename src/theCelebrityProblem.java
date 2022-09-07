import java.util.*;

public class theCelebrityProblem {
    // the solution approach link is given here , https://youtu.be/CiiXBvrX-5A
    // the approach is to eliminate all the non celebrities and then finally check whether the person is celebrity or not

    int celebrity(int M[][], int n)
    {
        // code here
        // doubt
        Stack<Integer> a=new Stack<>();
        for(int i=0;i<n;i++){
            a.push(i);
        }

        while(a.size()>1){
            int k=a.pop();
            int i=a.pop();
            if(M[i][k]==0){
                a.push(i);
            }
            else{
                a.push(k);
            }
        }

        int potent=a.peek();

        for(int i=0;i<n;i++){
            if(M[potent][i]!=0){
                return -1;
            }
        }

        for(int i=0;i<n;i++){
            if(i!=potent&& M[i][potent]==0){
                return -1;
            }



        }

        return potent ;
    }
}

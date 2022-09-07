import java.util.*;
//problem is to split the given binary string into substrings with equal zero and equal ones
public class splittingTheBinaryIntoEqualZerosAndOnes {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        char[] b=a.toCharArray();
        int[] c=new int[2];
        int u=0;
        for(int i=0;i<b.length;i++){
            if(b[i]=='0'){
                c[0]++;
            }
            else{
                c[1]++;
            }
            if(c[0]==c[1]){
                u++;
            }
        }
        System.out.println(u);
    }

}

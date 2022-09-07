import java.util.Scanner;
// doubt
public class printingAllPossibleSubsequences {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        int h=a.length();
        for(int i=0;i<h;i++){
            for(int j=i+1;j<=h;j++){
                System.out.println(a.substring(i,j));
            }
        }

    }

}

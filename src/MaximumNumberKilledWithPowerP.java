import java.util.Scanner;

public class MaximumNumberKilledWithPowerP {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int p=s.nextInt();
        int i=1;
        int c=0;
        while(p>i*i){
            p=p-i*i;
            c++;
            i++;
        }
        System.out.println(c);
    }
}

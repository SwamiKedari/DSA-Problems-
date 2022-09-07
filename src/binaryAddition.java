import java.util.*;
public class binaryAddition {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        char[] c=a.toCharArray();
        char[] d=b.toCharArray();
        int i=c.length;
        int j=d.length;
        int cr=0;
        int[] e=new int[Math.max(i,j)+1];
        int k=Math.max(i,j);
        while(i>0||j>0){
            if(i>0&&j>0){
            if(c[i-1]=='1'&&d[j-1]=='1'){
                e[k]=cr;
                cr=1;
                i--;
                j--;
                k--;
                continue;

            }
            else if((c[i-1]=='1'&&d[j-1]=='0')||(c[i-1]==0&&d[j-1]==1)){
                if(cr==1){
                    e[k]=0;
                    cr=1;
                }
                else{
                    e[k]=1;
                    cr=0;
                }
            }
            else{
                e[k]=cr;
                cr=0;
            }}
            else if(i>0&&j<=0){
                e[k]=c[i-1]+cr;
                cr=0;
            }
            else{
                e[k]=d[j-1]+cr;
                cr=0;
            }
            i--;
            j--;
            k--;
        }
        System.out.print(cr);
        e[k]=cr;
        System.out.println(Arrays.toString(e));
    }
}

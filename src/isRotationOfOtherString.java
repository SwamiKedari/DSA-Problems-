import java.util.*;
//taking individual substring of both the strings and comparing them , we can check if the both strings are rotations
//doubt
public class isRotationOfOtherString {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        if(areRotations(a,b)){
            System.out.println("yes, they are rotations of each other");}
        else{
            System.out.println("no;");
        }
    }

    private static boolean areRotations(String a,String b) {
        char[] c=a.toCharArray();
        char[] d=b.toCharArray();
        int i=0;
        while(c[0]!=d[i]){
            i++;
        }
        int h=a.length();
        if(a.substring(0,h-i).equals(b.substring(i,h))&&a.substring(h-i,h).equals(b.substring(0,i))){
            return true;
        }
        return false;
    }
}

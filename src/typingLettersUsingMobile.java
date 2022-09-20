import java.util.*;
//question no. 75 of final450
public class typingLettersUsingMobile {
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        String v=s.nextLine();
        // the string will have characters which will be achieved when the following sequence of characters will be achieved from the a array


        String[] a={
                "2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999"

        };
        print(v,a);



    }
    private static void print(String s,String[] a){
        int y=s.length();
        for(int i=0;i<y;i++){
            if (s.charAt(i)==' ') {
                System.out.print("0");

            }
            else{
                System.out.print(a[s.charAt(i)-'A']);
            }
        }
    }

}

import java.util.Scanner;
//java program to find the longest palindromic substring of the string
//time complexity of the question is o(n^2)
//this is the described time complexity in GEEKSFORGEEKS

public class longestPalindromicSubstring {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        System.out.println(longestPalin(a));
    }
    static String longestPalin(String s){
        // code here
        int k=s.length();
        int u=0;
        int v=1;
        int r=0;
        for(int i=0;i<k;i++){
            for(int j=i+1;j<=k;j++){
                if(isPalindrome(s.substring(i,j)) &&s.substring(i,j).length()>r){
                    r=s.substring(i,j).length();
                    u=i;
                    v=j;
                }
            }
        }
        return s.substring(u,v);

    }
    private static boolean isPalindrome(String s){
        char[] a=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(a[i]!=a[j]){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}

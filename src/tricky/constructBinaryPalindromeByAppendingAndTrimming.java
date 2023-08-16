package tricky;

public class constructBinaryPalindromeByAppendingAndTrimming {
    public static String binaryPalindrome (int n, int k) {
        //Complete the function
        //we have to find the binary palindrome by repeated appending and trimming of the binary characters
        //we are appending and trimming any binary strings of size k
        //this is done by just ensuring that the string that is developed is developed by appending
        // we just add 1s to the characters from the first and from the last
        // this characters will be separated by k
        char[] ch=new char[n];
        for(int i=0;i<n;i++){
            ch[i]='0';
        }
        for(int i=0;i<n;i+=k){
            ch[i]='1';
        }
        for(int i=n-1;i>-1;i-=k){
            ch[i]='1';
        }
        return String.valueOf(ch);
    }
}

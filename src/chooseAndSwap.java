import java.util.Arrays;

public class chooseAndSwap {
    String chooseandswap(String s){
        // Code Here
        // this is a greedy problem , first we will have to store the left most entry of all the characters in the array and then we have to check whether any smaller character has this value in array greater than the given element
        // doubt
        // https://practice.geeksforgeeks.org/problems/choose-and-swap0531/1/?page=6&difficulty[]=0&curated[]=7&sortBy=submissions
        int h=s.length();
        int[] a=new int[26];
        Arrays.fill(a,-1);
        for(int i=0;i<h;i++){
            char b=s.charAt(i);
            int t=b-'a';
            if(a[t]==-1){
                a[t]=i; // first we will store the left most entry of the characters in the array

            }
        }
        char w='9',v='0';

        for(int i=0;i<h;i++){
            char b=s.charAt(i);
            if(checkForSwap(a,b)!=b){
                w=b;
                v=checkForSwap(a,b);
                break;
            }
        }
        String str=""; // swap the elements

        for(int i=0;i<h;i++){
            char p=s.charAt(i);
            if(p==w){
                str+=v;
            }
            else if(p==v){
                str+=w;
            }
            else{
                str+=p;
            }
        }

        return str;
    }


    char checkForSwap(int[] a,char b){
        int t=b-'a';
        int m=a[t];
        for(int i=0;i<t;i++){
            if(a[i]>m){
                return (char)(i+97);
            }
        }

        return b;
    }
}

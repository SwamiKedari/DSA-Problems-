package tricky;

public class largestNumberInKSwaps {
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String s, int k)
    {
        //code here.
        //hint for this problem is to try all the possibilities with the k no of swaps and then get the best answer from it
        //we have to use backtracking to solve this problem, that means we will first swap the numbers and then we will change them to original position after swaping
        //inthis way, we will take the max number that is possible from the given numbers
        char[] ch=s.toCharArray();
        int n=s.length();
        char[] ans=new char[n];
        for(int i=0;i<n;i++){
            ans[i]='0';
        }
        getmax(ch,0,n,k,ans);
        return String.valueOf(ans);
    }

    public static void getmax(char[] ch,int i,int n,int k,char[] ans){
        if(i==n || k==0){
            //System.out.println("kjdljal");
            cmp(ch,ans);
            return;
        }
        char val=ch[i];
        for(int j=i+1;j<n;j++){
            if(ch[j]>=val){
                val=ch[j];
            }
        }

        for(int j=i+1;j<n;j++){
            if(ch[j]==val){
                swap(ch,i,j);
                getmax(ch,i+1,n,k-1,ans);
                swap(ch,i,j);
            }
        }
        getmax(ch,i+1,n,k,ans); // we will still have to move front even if there is no swap operation
        // every time, we will take the max element in the array from i to n and then swap the elements with that particular element

    }

    public static void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }

    public static void cmp(char[] ch,char[] ans){
        //System.out.println(String.valueOf(ch));
        //System.out.println(String.valueOf(ans));
        for(int i=0;i<ch.length;i++){
            if((int)ch[i]>(int)ans[i]){
                for(int j=0;j<ch.length;j++){
                    ans[j]=ch[j];
                }
                return;
            }
            else if(ch[i]!=ans[i]){
                break;
            }
        }
    }
}

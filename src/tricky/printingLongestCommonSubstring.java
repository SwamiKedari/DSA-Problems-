package tricky;
import java.util.*;

public class printingLongestCommonSubstring {
    public static void main(String[] swami){
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String st1=sc.nextLine();
        // we have to find the length of the common substring of the two strings and also print the substring
        // we will use the dp in tabulation and then backtrack to get the answer
        // first we will find the memoization part, then we will find the tabulation part, then we will use the tabulation part to get the answer
        int n=st.length(), m=st1.length();
        int[][] dp=new int[n+1][m+1];
        int maxl=-1, maxr=-1, ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(st.charAt(i-1)==st1.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>ans){
                    ans=dp[i][j];
                    maxl=i;
                    maxr=j;
                }
            }
        }

        for(int i=0;i<=n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        while(ans-->0){
            System.out.print(st.charAt(maxl-1));
            maxl--;
        }
        System.out.println();


    }

    public static int getlength(String st,String st1,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(st.charAt(i)==st1.charAt(j)){
            return dp[i][j]=1+getlength(st,st1,i-1,j-1,dp);
        }
        else{
            return dp[i][j]=0;
        }
    }

}

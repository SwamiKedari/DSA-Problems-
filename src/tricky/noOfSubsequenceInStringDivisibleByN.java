package tricky;

public class noOfSubsequenceInStringDivisibleByN {
    public int mod=(int)1e9+7;
    //having dp states for the order of int(s) will increase the time complexity
    // we will just find the answer by taking the modulus every time we add a new element
    // whenever we are taking a new element in the subsequence and the current sum is val, the new sum will be (val*10+num(new element))%n
    // we will get the answer when the i==n and the sum is equal to zero, then we can say that the subsequence is divisible by n
    public int countDivisibleSubseq(String s,int n)
    {
        // Your code goes here
        // we want to find the total number of subsequences that are divisible by n
        // we will mod each time we do the addition operation and then we will put the answer in the dp array
        char[] ch=s.toCharArray();
        int len=s.length();
        int[][] dp=new int[len][n];
        boolean[][] vis=new boolean[len][n];
        return getans(ch,0,0,len,n,dp,vis)-1;
    }

    public int getans(char[] ch,int i,int sum,int len,int n,int[][] dp,boolean[][] vis){

        if(i==len){
            if(sum==0){
                return 1;
            }
            return 0;
        }
        //System.out.println(sum);
        if(vis[i][sum]){
            return dp[i][sum]%mod;
        }
        int val1=getans(ch,i+1,(sum*10+num(ch[i]))%n,len,n,dp,vis);
        int val2=getans(ch,i+1,sum,len,n,dp,vis);
        vis[i][sum]=true;
        return dp[i][sum]=(val1+val2)%mod;
    }

    public int num(char ch){
        return ch-48;
    }
}

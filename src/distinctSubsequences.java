public class distinctSubsequences {// doubt
    // this is a dynamic programming based problem
    // contains the code submitted in gfg with space optimised part
    // you can check the tabulation and the recursion+memoization part from the space optimised part

    int  subsequenceCount(String s,String t)
    {
        // Your code here
	/*
	check the code with dp intellij

	*/

        int n=s.length();
        int m=t.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        prev[0]=1;
        curr[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=(prev[j-1]+prev[j])%1000000007;
                }
                else{
                    curr[j]=prev[j]%1000000007;
                }
            }

            prev=curr;
            curr=new int[m+1];
            curr[0]=1;

        }

        return prev[m];
    }

    int getTotal(String s,String t,int n,int m){
        if(m<0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(s.charAt(n)==t.charAt(m)){
            return getTotal(s,t,n-1,m-1)%1000000007 + getTotal(s,t,n-1,m)%1000000007;
        }
        else{
            return getTotal(s,t,n-1,m)%1000000007;
        }
    }
}

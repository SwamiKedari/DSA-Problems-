package tricky;

public class sumString {
    static int isSumString(String s){
        // code here
        // we will use the recursive function to solve this problem
        // there are two parameters inside the recursion for the last two numbers in the string
        // this will help us to compare the current value with the values that are present next in the array

        int n=s.length();
        boolean ans=gans(s,0,n,-1,-1,false);
        if(ans){
            return 1;
        }
        return 0;
    }

    static boolean gans(String s,int i,int n,double a,double b,boolean ist){
        if(i==n){
            if(ist){
                return true;
            }
            return false;
        }

        double val=0;
        boolean ans=false;
        for(int k=i;k<n;k++){
            val=val*10+getd(s.charAt(k));
            if(a==-1){
                ans|=gans(s,k+1,n,val,b,ist);
            }
            else if(b==-1){
                ans|=gans(s,k+1,n,a,val,ist);
            }
            else{
                if(val==a+b){
                    //System.out.println(val+" "+a+" "+b);
                    ans|=gans(s,k+1,n,b,val,true);
                }
            }
        }
        return ans;
    }

    static double getd(char ch){
        return (double)(ch-48);
    }
}

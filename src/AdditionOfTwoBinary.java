

public class AdditionOfTwoBinary {
    //In this question we performed the addition of 2 binary numbers and stored it in the form of an binary number

    public static void main(String[] args){
        String a="1001";
        String b="1010";
        System.out.println(a+"+"+b);
        String c=addBinary(a,b);

        System.out.println(c);
    }
    public static String addBinary(String a, String b) {
        int carry=0;
        int c1,c2;
        String sum="";
        int n=a.length()-1;
        int m=b.length()-1;
        while(n>=0&&m>=0){
            int r=((int)(a.charAt(n)))-48+((int)(b.charAt(m)))-48+carry;
            if(r>1){
                carry=1;
            }
            else{
                carry=0;
            }
            //System.out.println(r);

            sum=sum+r%2;
            n--;
            m--;
        }
        while(n>=0){
            int k=(int)a.charAt(n)-48+carry;
            if(k>1){
                carry=1;
            }
            else{
                carry=0;
            }
            //System.out.println(k);
            sum=sum+k%2;
            n--;
        }
        while(m>=0){
            int k=(int)(b.charAt(m))-48+carry;
            if(k>1){
                carry=1;
            }
            else{
                carry=0;
            }
            //System.out.println(k);
            sum=sum+k%2;
            m--;
        }
        if(carry==1){
            sum=sum+'1';
        }
        //System.out.println(sum);
        return rev(sum);
    }
    private static String rev(String a){
        String ans="";
        int n=a.length()-1;
        for(int i=n;i>-1;i--){
            ans=ans+a.charAt(i);
        }
        return ans;
    }
}

public class decimalToRoman {
    public int romanToDecimal(String str) {
        // code here
        return toroman(str);

    }
    public int toroman(String s){
        if(s.length()==1){
            return todec(s.charAt(0));
        }
        if(s.length()==2){
            if(todec(s.charAt(0))<todec(s.charAt(1))){
                return todec(s.charAt(1))-todec(s.charAt(0));
            }
            else{
                return todec(s.charAt(0))+toroman(s.substring(1,s.length()));
            }
        }
        if(todec(s.charAt(0))<todec(s.charAt(1))){
            return todec(s.charAt(1))-todec(s.charAt(0))+toroman(s.substring(2,s.length()));
        }

        else{
            return todec(s.charAt(0))+toroman(s.substring(1,s.length()));
        }

    }
    public int todec(char a){
        switch(a){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
}

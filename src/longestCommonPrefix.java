public class longestCommonPrefix {
    public String longestCommonPrefix(String[] s) {

        // we are comparing the adjacent elements and passing the output that we get from the previous comparisons to compare it with the next element
        // this assures that the prefix that we get will be common prefix among all the strings



        int k=s.length;
        if(k==1){
            return s[0];
        }
        StringBuilder a=commonOfTwo(s[0],s[1]);
        for(int i=2;i<k;i++){
            a=commonOfTwo(a.toString(),s[i]);
            if(a.length()==0){
                return a.toString();
            }

        }
        return a.toString();

    }


    private static StringBuilder commonOfTwo(String a,String b){
        char[] c=a.toCharArray();
        char[] d=b.toCharArray();
        StringBuilder s=new StringBuilder();
        int i=0;
        while(i<Math.min(c.length,d.length)&&c[i]==d[i]){
            s.append(c[i]);
            i++;
        }
        return s;
    }
}

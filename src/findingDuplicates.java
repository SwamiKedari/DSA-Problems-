//maintaining the count array for the number of duplicates by converting the char values into int and then again converrting to char
    public class findingDuplicates{
        public static void main(String[] args){
            String g="geeksforgeeks";
            char[] a=g.toCharArray();
            System.out.println(maxElements(a));
        }
        private static char maxElements(char[] a){
            int[] p=new int[26];
            int k=a.length;
            for(int i=0;i<k;i++){
                p[(int)a[i]-97]++;
            }
            int j=0;
            int u=0;
            for(int i=0;i<26;i++){
                if(p[i]>j){
                    j=p[i];
                    u=i;
                }}
            return (char)(u+97);
        }
    }


package tricky;

public class countNumberOfSubstrings {
    long substrCount (String s,int k) {
        // your code here
        // we will find the substrings with max length k and max length k-1
        // and then taking the difference, we will get the answer
        // we will move the window when the no of substrings has no of distinct characters less than k
        // the answer will be total substrings with distinct characters less than k and total substrings with less than k-1
        // this will give us the answer for the exact equal to k answer
        return getans(s,k)-getans(s,k-1);
    }

    long getans(String s,int k){
        int[] fr=new int[26];
        int dist=0, n=s.length(), l=0;
        long ans=0;
        char[] ch=s.toCharArray();
        for(int i=0;i<n;i++){
            if(fr[ch[i]-97]==0){
                dist++;
            }
            fr[ch[i]-97]++;
            while(dist>k){
                fr[ch[l]-97]--;
                if(fr[ch[l]-97]==0){
                    dist--;
                }
                l++;
            }
            ans+=(i-l+1);
        }

        return ans;
    }

}

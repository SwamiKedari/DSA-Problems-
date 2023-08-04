package tricky;

public class countPalindromicSubstrings
{
    public int CountPS(String s,int n)
    {
        //code here
        // we can solve this problem using the center point concept , we will consider the center point at each index and try to expand to the right and the left
        // every expanded substrings will be a palindrome , so the ct will increase by 1
        char[] ch=s.toCharArray();
        int ct=0;
        for(int i=0;i<n;i++){
            int l=i-1, r=i+1;
            while(l>=0 && r<n && ch[l]==ch[r]){
                ct++;
                l--;
                r++;
            }
        }

        for(int i=1;i<n;i++){
            int l=i-1, r=i;
            while(l>=0 && r<n && ch[l]==ch[r]){
                ct++;
                l--;
                r++;
            }
        }

        return ct;

    }
}
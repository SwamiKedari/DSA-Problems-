package tricky;

public class countOfDistinctSubstrings
{
    public static int countDistinctSubstring(String st)
    {
        //your code here
        //we are asked to find the total no of distinct substrings in the string st
        //we can solve this problem using hashset, but it will be o n3
        //we will be using trie to solve this problem, we will insert all the substrings and increment the counter whenever there is no node for the current character existing in the string

        int n=st.length();
        char[] ch=st.toCharArray();
        tnd root=new tnd();
        int ans=1;
        for(int i=0;i<n;i++){
            tnd cur=root;
            for(int j=i;j<n;j++){
                char chval=ch[j];
                tnd ele=cur.child[chval-97];
                if(ele==null){
                    ans++;
                    cur.child[chval-97]=new tnd();
                }
                cur=cur.child[chval-97];
            }
        }

        return ans;

    }
}

class tnd
{
    tnd child[];
    public tnd(){
        child=new tnd[26];
    }
}
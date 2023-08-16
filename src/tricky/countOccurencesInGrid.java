package tricky;

public class countOccurencesInGrid {
    public int findOccurrence(char a[][], String t)
    {
        // Write your code here
        // we have to go to all the four directions from the current index till length in with target
        // and we have to compare the characters to get the answer
        // we will backtrack and then move to the next path
        // explore all the paths and then get the answer
        // we are asked to find the total number of paths that make the given string in the given character array a

        char[] ch=t.toCharArray();
        int n=a.length, m=a[0].length, len=ch.length;
        boolean[][] vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==ch[0]){
                    ans+=getans(a,vis,ch,i,j,0,n,m,len);
                }
            }
        }
        return ans;
    }

    public int getans(char[][] a,boolean[][] vis,char[] ch,int i,int j,int ind,int n,int m,int len){
        if(ind==len-1){
            return 1;
        }
        int ans=0;
        vis[i][j]=true;
        int[] xi={-1,0,1,0};
        int[] yi={0,1,0,-1};
        for(int k=0;k<4;k++){
            int i1=i+xi[k], j1=j+yi[k];
            if(isv(a,vis,ch,i1,j1,n,m,ind+1)){
                ans+=getans(a,vis,ch,i1,j1,ind+1,n,m,len);

            }
        }
        vis[i][j]=false;
        return ans;
    }

    public boolean isv(char[][] a,boolean[][] vis,char[] ch,int i,int j,int n,int m,int ind){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return a[i][j]==ch[ind] && !vis[i][j];
    }
}

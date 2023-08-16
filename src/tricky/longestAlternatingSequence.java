package tricky;

public class longestAlternatingSequence {
    public int AlternatingaMaxLength(int[] a)
    {
        // code here
        // we have to consider the previous entry and the next entry will be formed accordingly
        // if the previously peak was taken and we have a value that is greater than the peak, we will update it
        // similarly, if we have a depth and we took the depth previously that was smaller than the current depth, than the current depth will new depth and next values will be taken accordingly

        int ct=0, pre=Integer.MIN_VALUE;
        int n=a.length;
        boolean isab=true;
        int ans=0;
        for(int i=0;i<n;i++){
            if(a[i]>pre && isab){
                ct++;
                pre=a[i];
                isab=false;
            }
            else if(a[i]<pre && !isab){
                ct++;
                pre=a[i];
                isab=true;
            }
            else if(isab){
                pre=Math.min(pre,a[i]);
            }
            else if(!isab){
                pre=Math.max(pre,a[i]);
            }
        }

        isab=false; pre=Integer.MAX_VALUE;
        ans=Math.max(ans,ct);
        ct=0;
        for(int i=0;i<n;i++){
            if(a[i]>pre && isab){
                ct++;
                pre=a[i];
                isab=false;
            }
            else if(a[i]<pre && !isab){
                ct++;
                pre=a[i];
                isab=true;
            }
            else if(isab){
                pre=Math.min(pre,a[i]);
            }
            else if(!isab){
                pre=Math.max(pre,a[i]);
            }
        }
        ans=Math.max(ans,ct);
        return ans;
    }
}

package tricky;
import java.util.*;
public class minMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        // dfs will not work in this case as it will give stack over flow error
        // we will use bfs
        Queue<Integer> que=new LinkedList<>();
        int[] val=new int[100001];
        Arrays.fill(val,Integer.MAX_VALUE);
        que.add(start);
        val[start]=0;
        while(!que.isEmpty()){
            int value=que.remove();
            for(int k: arr){
                int n=(value*k)%100000;
                if(val[n]>val[value]+1){
                    val[n]=val[value]+1;
                    que.add(n);
                }
            }
        }
        if(val[end]==Integer.MAX_VALUE){
            return -1;
        }
        return val[end];
    }

    int getans(int[] a,int st,int end,int[] val){
        if(st==end){
            return 0;
        }
        val[st]=1;
        int ans=(int)1e6;
        for(int k: a){
            int value=(k*st)%100000;
            if(val[value]==0){
                ans=Math.min(ans,getans(a,value,end,val)+1);
            }
        }

        return ans;
    }
}

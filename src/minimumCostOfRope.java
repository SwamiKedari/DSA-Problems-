import java.util.*;
public class minimumCostOfRope {
    // doubt
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        // your code here
        PriorityQueue<Long> que=new PriorityQueue<Long>();
        for(int i=0;i<n;i++){
            que.add(arr[i]);
        }
        long cost=0;
        long ans=0;
        while(que.size()>1){
            long h1=que.poll();
            long h2=que.poll();

            cost=h1+h2;
            que.add(cost);
            ans+=cost;
            cost=0;
            //System.out.println(que);
        }
        //ans+=que.poll();
        return ans;
    }
}

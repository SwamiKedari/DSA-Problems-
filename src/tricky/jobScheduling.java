package tricky;
import java.util.*;
public class jobScheduling {
    //Function to find the maximum profit and the number of jobs done.
    // we will arrange the jobs in decreasing order of profit and then we will take the job if there is slot <= its deadline available currently
    // this will give us the answer in (nlogn) 
    int[] JobScheduling(Job a[], int n)
    {
        // Your code here
        Arrays.sort(a,new Comparator<Job>(){
            public int compare(Job a,Job b){
                if(a.profit>b.profit){
                    return -1;
                }
                else if(a.profit<b.profit){
                    return 1;
                }
                return 0;
            }
        });

        TreeSet<Integer> set=new TreeSet<>();
        for(int i=1;i<=n;i++){
            set.add(i);
        }
        int tot=0 ,totpro=0;
        for(int i=0;i<n;i++){
            Job jb=a[i];
            int k=jb.deadline;
            Integer fl=set.floor(k);
            if(fl!=null){
                set.remove(fl);
                tot++; totpro+=jb.profit;
            }
        }

        int[] ans={tot,totpro};
        return ans;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

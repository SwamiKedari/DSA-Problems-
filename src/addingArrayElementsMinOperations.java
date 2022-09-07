import java.util.PriorityQueue;

public class addingArrayElementsMinOperations {
    int minOperations(int[] a, int n, int k) {
        // code here
        PriorityQueue<Integer> que=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            que.add(a[i]);
        }
        int op=0;
        while(que.peek()<k){
            int a1=que.remove();
            int a2=que.remove();
            que.add(a1+a2);
            op++;
        }
        return op ;
    }
}

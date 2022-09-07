import java.util.*;

public class maxOfAllSubArraysOfSizeK {// doubt
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        // Your code here
        // use a deque to store the elements ,if dequeue has element in the back which is lesser than the current element ,
        // we replace the element from the back and we add new element to the back ,
        // the first element of the queue will give the answer of max element in each window
        Deque<Integer> b=new LinkedList<>();
        ArrayList<Integer> c=new ArrayList<>();
        b.addFirst(0);
        for(int i=1;i<k;i++){
            int j=b.peekLast();
            //System.out.println(b);
            while(a[i]>a[j]){
                //System.out.println(j+"&");
                b.removeLast();
                if(b.size()==0){
                    break;
                }
                j=b.peekLast();

            }

            b.addLast(i);
            // System.out.println(b);
        }

        c.add(a[b.peekFirst()]);
        for(int i=k;i<n;i++){
            removeDeque(b,i-k+1,i);
            int j=i;
            if(b.size()>0){
                j=b.peekLast();
            }

            //System.out.println(b);
            while(a[i]>a[j]){
                //System.out.println(j+"&");
                b.removeLast();
                if(b.size()==0){
                    break;
                }
                j=b.peekLast();

            }

            b.addLast(i);

            c.add(a[b.peekFirst()]);
        }


        return c;
    }

    static void removeDeque(Deque<Integer> a,int i,int k){
        int j=a.peekFirst();
        while(j<i || j>k){
            a.removeFirst();
            if(a.size()==0){
                return;
            }
            j=a.peekFirst();
        }

    }
}

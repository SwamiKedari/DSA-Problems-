import java.util.ArrayList;

public class LeadersInAnArray {
    // doubt
    static ArrayList<Integer> leaders(int a[], int n){
        // Your code here
        ArrayList<Integer> b=new ArrayList<>();
        int k=0;
        for(int i=n-1;i>-1;i--){
            if(a[i]>=k){
                b.add(a[i]);
                k=a[i];
            }
        }
        int g=b.size()/2;
        for(int i=0;i<g;i++){
            int u=b.get(i);
            b.set(i,b.get(b.size()-i-1));
            b.set(b.size()-i-1,u);

        }
        return b;

    }
}

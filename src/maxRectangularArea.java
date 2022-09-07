import java.util.Stack;

public class maxRectangularArea {
    public static long getMaxArea(long[] hist, long n)
    {
        // your code here
        // we just want to find the limits of index in which a particular rectangle is expanded , then we will use it to get the max rectangle
        // the time complexity of this problem is o(n)
        // maximum area inside a histogram
        // create 2 arrays , one for storing the elements just greater than the previous ,and one for storing the element just smaller than the previous
        // then use this arrays to find the area
        Stack<Integer> a=new Stack<>();
        Stack<Integer> b=new Stack<>();
        long[] c=new long[(int)n];
        long[] d=new long[(int)n];
        for(int i=0;i<(int)n;i++){
            long k=hist[i];
            if(a.size()==0){
                c[i]=-1;
            }
            else{
                while(a.size()>0 && k<=hist[a.peek()]){
                    a.pop();
                }
                if(a.size()>0){
                    c[i]=a.peek();
                }
                else{
                    c[i]=-1;
                }


            }
            a.push(i);
        }

        for(int i=(int)(n-1);i>-1;i--){
            long k=hist[i];
            if(b.size()==0){
                d[i]=n;
            }
            else{
                while(b.size()>0 && k<=hist[b.peek()]){
                    b.pop();
                }
                if(b.size()>0){
                    d[i]=b.peek();
                }
                else{
                    d[i]=n;
                }
            }
            b.push(i);
        }

        //System.out.println(Arrays.toString(c));
        //System.out.println(Arrays.toString(d));
        long max=0;
        for(int i=0;i<(long)n;i++){
            long area=hist[i]*(d[i]-c[i]-1);
            if(max<area){
                max=area;
            }
        }
        return max;

    }
}

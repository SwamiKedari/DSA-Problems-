import java.util.Stack;

public class maxRectangleInTheMatrix {
    public int maxArea(int h[][], int n, int m) {
        // add code here.
        // in this question , we have to find the largest rectangle in the matrix n*m
        // the largest rectangle can be achieved using the extended version of the largest rectangle in the histogram problem
        // we need to treat each row as the base of the histogram and then we need to find the maximum area of the rectangle for that particular row, this will help us to get the maximum area in the whole 2d array
        // first we will write the code to find the maximum rectangle inthe case of a histogram and then we will use it to get the maximum area rectangle
        // we solved the question using the max rectangle in the case of the histogram and this solution is o(n*m) solution
        // we didnot use dp over here but solved using similar logic that we used in the case of the largest rectangle in the case of the histogram

        int[] a=new int[m];
        for(int i=0;i<m;i++){
            a[i]=h[0][i];
        }
        int max=getMaxArea(a,m);
        int maxInd=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){

                if(h[i][j]==0){
                    a[j]=0;
                }
                else{
                    a[j]+=1;
                }


            }

            int h1=getMaxArea(a,m);
            if(max<h1){
                max=h1;
                maxInd=i;
            }

        }



        return max;


    }
    public static int getMaxArea(int hist[], int n)
    {
        // your code here
        // we will use stack to solve this problem using two arrays
        Stack<Integer> left=new Stack<>();
        int[] lInd=new int[n];
        int len=hist.length;
        for(int i=0;i<len;i++){
            while(!left.isEmpty() && hist[left.peek()]>=hist[i]){
                left.pop();
            }
            if(left.isEmpty()){
                lInd[i]=-1;
            }
            else{
                lInd[i]=left.peek();
            }
            left.push(i);
        }



        Stack<Integer> right=new Stack<>();
        int[] rInd=new int[(int)n];
        for(int i=len-1;i>-1;i--){
            while(!right.isEmpty() && hist[right.peek()]>=hist[i]){
                right.pop();
            }
            if(right.isEmpty()){
                rInd[i]=n;
            }
            else{
                rInd[i]=right.peek();
            }
            right.push(i);
        }


        int max=0;

        for(int i=0;i<len;i++){
            int rect=hist[i]*(rInd[i]-lInd[i]-1);
            if(max<rect){
                max=rect;
            }
        }
        return max;


    }
}

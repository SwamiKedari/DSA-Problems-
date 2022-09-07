// { Driver Code Starts
//Initial Template for Java

import java.util.*;
// no clear description
public class commonOfThreeArrays
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];

            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            sc.next();
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            sc.next();
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3)
    {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> v=new ArrayList<Integer>();
        for(int i=0;i<n1;i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);

            }
            else{
                map.put(a[i],map.get(1));
            }
        }
        for(int i=0;i<n2;i++){
            if(map.containsKey(b[i])){
                map.put(b[i],map.get(b[i])+1);

            }

        }
        for(int i=0;i<n3;i++){
            if(map.containsKey(c[i])){
                map.put(c[i],map.get(c[i])+1);
                if(map.get(c[i])>=3){
                    v.add(c[i]);
                }

            }

        }
        System.out.println(v.size()+1);
        return v;

    }
}
package tricky;
import java.util.*;

public class largestSumSubmatrixWithSumZero {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        // code here
        // we will check where the values of the matrices are repeating, then that part will have the given value of the subrectangle equal to zero
        // in this question, we will use the similar algorithm to the finding of the maximum submatrix sum in the rectangle
        // this will give the value of the answer
        int n=a.length;
        int m=a[0].length;
        int ans1=Integer.MIN_VALUE;
        int indc1=-1, indc2=-1;
        int indr1=-1, indr2=-1;
        for(int j=0;j<m;j++){
            int[] val=new int[n];

            for(int k=j;k<m;k++){
                for(int i=0;i<n;i++){
                    val[i]+=a[i][k];
                }

                // this will give the value of the array which corresponds to the that section, then we just need to find the maximum value of the array in the area
                HashMap<Integer,Integer> map=new HashMap<>();
                map.put(0,-1);

                int sum=0;
                int ans=Integer.MIN_VALUE;
                int ind1=-1, ind2=-1;
                for(int i=0;i<n;i++){
                    sum+=val[i];
                    if(map.containsKey(sum)){
                        if(ans<(i-map.get(sum))){
                            ans=i-map.get(sum);
                            ind1=map.get(sum)+1;
                            ind2=i;
                        }
                    }
                    else{
                        map.put(sum,i);
                    }
                }

                if(ind1>-1 && ind2>-1 && ans1<(k-j+1)*(ind2-ind1+1)){
                    ans1=(k-j+1)*(ind2-ind1+1);
                    indc1=j;
                    indc2=k;
                    indr1=ind1;
                    indr2=ind2;
                    //System.out.println(Arrays.toString(val));
                }
            }


        }

        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        if(indc1==-1 || indc2==-1 || indr1==-1 || indr2==-1){
            return ar;
        }
        for(int i=indr1;i<=indr2;i++){
            ArrayList<Integer> ar1=new ArrayList<>();
            for(int j=indc1;j<=indc2;j++){
                ar1.add(a[i][j]);
            }
            ar.add(ar1);
        }
        return ar;

    }
}

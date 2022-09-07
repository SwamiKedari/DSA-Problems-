import java.util.*;

public class mockTestPlacements {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int h,k,g,b;
        int[] x=new int[n];
        int[] y=new int[n];
        //int[] ans=new int[n];


        for(int i=0;i<n;i++){
            x[i]=s.nextInt();
            y[i]=s.nextInt();

        }
        int d=s.nextInt();
        for(int i=0;i<n;i++){
            if(i==0){
                 h=x[i+1];
                 k=y[i+1];
                 g=x[n-1];
                 b=y[n-1];

            }
            else if(i<n-1){
             h=x[i-1];
             k=y[i-1];
             g=x[i+1];
             b=y[i+1];}
            else{
                h=x[i-1];
                k=y[i-1];
                g=x[0];
                b=y[0];
            }
            double c=(double)(k-y[i])/(double)(h-x[i]);
            double e=(double)(b-y[i])/(double)(g-x[i]);
            double c1=k-(c*h);
            double c2=b-(e*g);
            double[] c11=new double[2];
            c11[0]=c1+d*Math.sqrt(1+c*c);
            c11[1]=c1-d*Math.sqrt(1+c*c);
             double[] c22=new double[2];
             c22[0]=c2+d*Math.sqrt(1+e*e);
             c22[1]=c2-d*Math.sqrt(1+e*e);
            double[] xi=new double[4];
            double[] yi=new double[4];
            for(int v=0;v<2;v++){
               xi[v]=(c22[v]-c11[0])/(c-e);
               yi[v]=(e*c22[v]-c*c11[0])/(c-e);
            }
            for(int v=2;v<4;v++){
                xi[v]=(c22[v-2]-c11[1])/(c-e);
                yi[v]=(e*c22[v-2]-c*c11[1])/(c-e);
            }
            System.out.println(Arrays.toString(xi));
            System.out.println(Arrays.toString(yi));




        }




    }
}

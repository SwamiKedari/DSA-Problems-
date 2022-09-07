import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int arr[],int l,int r){
       if(l<r){
           int mid=(l+r)/2;
           mergeSort(arr,l,mid);
           mergeSort(arr,mid+1,r);
           merge(arr,l,mid,r);
       }
    }

    public static void main(String[] swami){
        int[] a={4,5,1, 3, 9 ,7 ,1000, 89 ,-1 ,78};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] a,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] b=new int[n1];
        int[] c=new int[n2];
        for(int i=0;i<n1;i++){
            b[i]=a[i+l];
        }
        for(int i=0;i<n2;i++){
            c[i]=a[i+m+1];
        }

        int k=0 , g=0 , j=l;
        while(k!=n1 && g!=n2){
            if(b[k]<c[g]){
                a[j]=b[k];
                k++;
                j++;
            }
            else if(b[k]>=c[g]){
                a[j]=c[g];
                g++;
                j++;
            }
        }

        while(k!=n1){
            a[j]=b[k];
            j++;
            k++;
        }

        while(g!=n2){
            a[j]=c[g];
            g++;
            j++;
        }
    }
}

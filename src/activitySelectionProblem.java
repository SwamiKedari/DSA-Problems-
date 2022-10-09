public class activitySelectionProblem {
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        // the person can work on a single activity on a single day
        // the logic to solve this problem is as follows :
        // sort the start and end on the basis of the end elements
        // then we will just need to get the count by comparing the start element of the next index and the end index of the current element
        // because the activities are sorted based on the end element ,the tasks will be selected in the order from left to right and can be achieved by comparing the start index of next element and the end index of the previous element

        quickSort(start,end,0,n-1);

        int count=1;
        int i=1;
        int j=0;
        while(i<n){
            if(start[i]>end[j]){
                count++;
                j=i;
                i++;
            }
            else{
                i++;
            }
        }
        return count;
    }

    public static void quickSort(int[] s,int[] e,int i,int j){
        if(i<j){
            int pivot = partition(s,e,i,j);
            quickSort(s,e,i,pivot-1);
            quickSort(s,e,pivot+1,j);
        }
    }

    public static int partition(int[] s,int[] e,int l,int h){
        int i=l-1;
        int pivot=e[h];
        for(int j=l;j<h;j++){
            if(pivot>e[j]){
                i++;
                swap(s,e,i,j);
            }

        }
        swap(s,e,i+1,h);

        return i+1;
    }

    public static void swap(int[] s,int[] e,int i,int j){
        int temp=s[i];
        s[i]=s[j];
        s[j]=temp;

        int temp1=e[i];
        e[i]=e[j];
        e[j]=temp1;
    }
}

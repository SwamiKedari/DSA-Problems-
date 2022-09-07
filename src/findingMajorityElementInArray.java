public class findingMajorityElementInArray {
    static int majorityElement(int a[], int size)
    {
        // your code here
        // doubt

        int cand=findCandidate(a,size);
        int k=0;
        for(int i=0;i<size;i++){
            if(a[i]==cand){
                k++;
            }
        }
        if(k>size/2){
            return cand;
        }
        return -1;
    }
    static int findCandidate(int a[],int size){
        //this function always returns the element with maximum frequency in the array in o(n) time complexity

        int cand=a[0];
        int ind=0 ,count=1;
        for(int i=1;i<size;i++){
            if(cand==a[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                cand=a[i];
                count=1;
            }
        }
        return cand;
    }
}

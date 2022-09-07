public class minNumberOfSwapsToBalance {
    static int minimumNumberOfSwaps(String s){
        // doubt
        // code here
        // keep a counter to maintain the value of open bracket
        // we decrease the count if we encounter a opening bracket , increase it if we encounter a closing bracket
        // if count > 0 , then we add the value of count to swap
        // we will require a swap for each closing bracket that appears before the opening bracket
        // this condition occurs when the count value is greater than zero
        // so we add all the count values which have value greater than the zero

        int count=0;
        int swap=0;
        int k=s.length();
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='['){
                count--;
            }
            else{
                count++;
                if(count>0){
                    swap+=count;
                }

            }
        }
        return swap;
    }
}

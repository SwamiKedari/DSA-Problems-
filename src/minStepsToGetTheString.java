public class minStepsToGetTheString {
    // in this question, we are asked to find the minimum number of steps we should do to get the string
    // link : https://practice.geeksforgeeks.org/problems/minimal-moves-to-form-a-string4331/1?page=3&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    int minSteps(String s) {
        // code here
        // we will use the iterative approach to solve this problem
        int n=s.length();
        int count=1;
        while(n!=1){
            if(n%2==0){
                if(s.substring(0,n/2).equals(s.substring(n/2,n))){
                    s=s.substring(0,n/2);
                    count++;
                    n=n/2;
                }
                else{
                    s=s.substring(0,n-1);
                    count++;
                    n--;
                }

            }
            else{
                s=s.substring(0,n-1);
                count++;
                n--;
            }
        }

        return count;
    }
}

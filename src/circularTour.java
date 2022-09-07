public class circularTour {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    // the logic for this code is that all the points between 2 points having balance zero or less than zero can not do the circular tour
    // for checking whether there is no such point which satisfies the condition we use a count variable and use it to return -1 if value of count is greater than 1 ie f loops twice

    // doubt
    int tour(int p[], int d[])
    {


        int balance =0;
        int f=0;
        int r=0;
        int n=p.length;
        if(n==1){
            return 0;
        }
        boolean istrue=true;
        int count=0;
        while(f!=r || istrue){
            balance+=p[f]-d[f];


            f++;
            if(f==n){
                f=0;
                count++;
                if(count>1){
                    return -1;
                }
            }
            if(balance<0){
                if(f<r){
                    return -1;
                }
                istrue=true;
                r=f;
                balance=0;
            }
            else{
                istrue=false;
            }

        }
        return f;
    }
}

public class josephusProblem {
    public int josephus(int n, int k)
    {// doubt
        //Your code here
        //this code is the solution to the problem to check whether which positiion on the circle is used to survive till last when the kth person is killed
        //keep a counter which will be equal to the given elements and then loop through the empty array to get the index position of the element which survivied from the attack
        if(n==1){
            return 1;
        }

        return (josephus(n-1,k)+k-1)%n +1;
    }
}

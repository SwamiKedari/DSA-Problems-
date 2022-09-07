public class polynomialAddition {
    public static polNode addPolynomial(polNode p1,polNode p2)
    {
        //Add your code here.
        // we will merge the 2 linkedlists, then we will compare the adjacent nodes and remove one of them if value of both is equal
        polNode head=null;
        if(p1.pow>p2.pow){
            head=p1;
            p1=p1.next;
        }
        else if(p1.pow<p2.pow){
            head=p2;
            p2=p2.next;
        }
        else{
            head=p1;
            p1.coeff+=p2.coeff;
            p1=p1.next;
            p2=p2.next;
        }
        polNode conn=head;
        while(p1!=null && p2!=null){
            if(p1.pow>p2.pow){
                conn.next=p1;
                conn=p1;
                p1=p1.next;

            }
            else if(p1.pow==p2.pow){
                conn.next=p1;
                conn=p1;
                p1.coeff+=p2.coeff;
                p1=p1.next;
                p2=p2.next;
            }
            else{
                conn.next=p2;
                conn=p2;
                p2=p2.next;
            }
        }

        if(p1==null){
            conn.next=p2;
        }
        else{
            conn.next=p1;
        }


        return head;
    }
}

class polNode{
    int pow ;
    int coeff;
    polNode next;
}

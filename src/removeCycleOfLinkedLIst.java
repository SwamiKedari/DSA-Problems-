

public class removeCycleOfLinkedLIst {// doubt
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node fast=head;
        Node slow=head;
        fast=fast.next.next;
        slow=slow.next;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return;
            }
            fast=fast.next.next;
            slow=slow.next;
            // System.out.println(fast.data);
            //System.out.println(slow.data);
        }
        if(fast.next==null){
            return ;
        }
        Node check=fast;
        //System.out.println(check.data);

        fast=fast.next;
        int k=1;
        while(fast!=check){
            fast=fast.next;
            k++;
        }
        Node a=head;
        for(int i=0;i<k;i++){
            a=a.next;
        }
        while(head!=a){
            head=head.next;
            a=a.next;
        }
        Node pivot =a ;
        while(a.next!=pivot){
            a=a.next;
        }
        a.next=null;



    }
}

class Node{
       Node next;
       int data;
       Node(int data){
           this.data=data;
       }
}

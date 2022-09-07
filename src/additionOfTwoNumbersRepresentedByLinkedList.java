public class additionOfTwoNumbersRepresentedByLinkedList {

    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        // add the reverse the linked list function
        // add and carry from end , increase one node in some cases
        // reverse the linked list again
        // reverse the linked list again
        Node a = reverse(first);
        Node b = reverse(second);
        int sum =0;
        int carry =0;
        Node c = null;
        Node j = null;

        sum = a.data+b.data;
        if(sum<10){
            c=new Node(sum);
            j=c;
            carry=0;

        }
        else{
            c=new Node(sum-10);
            carry=1;
            j=c;

        }
        a=a.next ;
        b=b.next;
        while(a!=null && b!=null){
            sum = a.data+b.data+carry ;
            if(sum<10){
                c.next=new Node(sum);
                carry = 0;
            }
            else{
                c.next=new Node(sum-10);
                carry=1;
            }
            c=c.next;
            a=a.next;
            b=b.next;
        }

        while(a!=null){
            sum=a.data+carry;
            if(sum<10){
                c.next=new Node(sum);
                carry=0;
            }
            else{
                c.next=new Node(sum-10);
                carry=1;
            }
            c=c.next;
            a=a.next;
        }
        while(b!=null){
            sum=b.data+carry;
            if(sum<10){
                c.next=new Node(sum);
                carry=0;
            }
            else{
                c.next=new Node(sum-10);
                carry =1 ;
            }
            c=c.next;
            b=b.next;
        }

        if(carry == 1){
            c.next=new Node(1);

        }

        return reverse(j);


    }


    static Node reverse(Node n){
        Node curr = n;
        Node pre = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = pre;
            pre =curr ;
            curr=next;
        }


        return pre;
    }

}

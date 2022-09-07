public class reversingDoublyLinkedList {
    //code to reverse a doubly linked list 
    public static Node reverseDLL(Node  head)
    {
        //Your code here
        Node pre=null;
        Node next=null;
        Node curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            //curr.prev=next; the original line in code did not had this comment
            pre=curr;
            curr=next;
        }
        return pre;
    }

}

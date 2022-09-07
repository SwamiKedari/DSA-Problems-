public class linkedListPalindrome{
    //Function to check whether the list is palindrome.
    // the idea is to reverse the later half of the linkedlist and then compare the elements of the linkedlist from the start and the middle
    // if the element matches , then the linkedlist is a palindrome , else it is not a palindrome
    boolean isPalindrome(Node head)
    {
        Node slow=head;
        Node fast=head;
        if(head.next!=null&&head.next.next==null){
            if(head.data!=head.next.data){
                return false;
            }
            return true;
        }
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //System.out.println(slow.data);
        Node end=reverse(slow);
        //System.out.println(end.data);
        while(end!=slow&&head!=slow.next){
            if(end.data!=head.data){
                return false;
            }
            end=end.next;
            head=head.next;
        }
        return true;
    }
    Node reverse(Node mid){
        Node pre=mid;
        Node next=mid;
        Node curr=mid.next;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}

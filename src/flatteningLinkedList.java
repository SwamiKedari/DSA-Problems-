public class flatteningLinkedList {
    // doubt
    bNode flatten(bNode root)
    {
        // Your code here
        // we will merge the adjacent linkedlists and then keep on returning the starting position of the linkedlist
        bNode a=root;
        while(root.next!=null){
            root=merge(root);

        }
        return root;
    }

    bNode merge(bNode a){
        if(a.next==null){
            return a;
        }
        bNode b=a.next.next;
        a.next.next=null;
        bNode root=a;
        //Node k=a.next;
        if(a.data > root.next.data){
            bNode cnode=root.next.bottom;
            root.next.bottom=a;
            root=root.next;
            root.next=cnode;
        }
        while(a.bottom!=null && root.next!=null){
            if(a.bottom.data >root.next.data){
                bNode nextBottom=a.bottom;
                //System.out.println(nextBottom.data+" *** ");
                //System.out.println(root.next.data+"||||");
                a.bottom=root.next;
                bNode k=root.next.bottom;
                root.next.bottom=nextBottom;

                root.next=k;
                //a.bottom.bottom=nextBottom;

            }
            a=a.bottom;

        }
        if(a.bottom==null){
            a.bottom=root.next;
        }

        root.next=b;
        //printList(root);
        return root;






    }

    public void printList(bNode root){
        while(root!=null){
            //System.out.print(root.data+" ");
            root=root.bottom;
        }
        System.out.println();

    }
}

class bNode{
    bNode next;
    bNode bottom;
    int data;

}

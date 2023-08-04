//{ Driver Code Starts
class test
{

    public static void main(String[] swami){
        Node a=new Node(0);
        Node head=a;
        for(int i=1;i<10;i++){
            Node k=new Node(i);
            a.next=k;
            a=a.next;
        }
        Node rev=reverse(head,4);
        while(rev!=null){
            System.out.println(rev.data);
            rev=rev.next;
            //break;
        }
    }
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node first=node, sec=node;
        int ct=0;
        while(first!=null){
            first=first.next;
            ct++;
        }
        Node[] val=getrev(sec,null,k);
        Node ans=val[0];
        if(ct<k){
            return val[0];
        }

        for(int i=k;i<ct;i+=k){
            Node cur=val[2];
            System.out.println(val[0].data+" "+val[1].data+" "+val[2].data);
            Node[] v1=getrev(cur,null,k);
            System.out.println(v1[0].data+" "+v1[1].data+" ");
            val[1].next=v1[0];
            val[1]=v1[1];
            val[2]=v1[2];

        }

        return ans;
    }

    public static Node[] getrev(Node cur,Node pre,int k){
        Node next=cur.next;
        Node head=cur;
        //System.out.println(cur);
        for(int i=0;cur!=null && i<k;i++){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        //System.out.println(pre.data);
        Node[] a={pre,head,cur};
        return a;
    }
}


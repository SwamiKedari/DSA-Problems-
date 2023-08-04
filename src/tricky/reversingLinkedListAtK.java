package tricky;

public class reversingLinkedListAtK
{
    public static lNode reverse(lNode lNode, int k)
    {
        //Your code here
        lNode first=lNode, sec=lNode;
        int ct=0;
        while(first!=null){
            first=first.next;
            ct++;
        }
        lNode[] val=getrev(sec,null,k);
        lNode ans=val[0];
        if(ct<k){
            return val[0];
        }

        for(int i=k;i<ct;i+=k){
            lNode cur=val[2];
            lNode[] v1=getrev(cur,null,k);
            val[1].next=v1[0];
            val[1]=v1[1];
            val[2]=v1[2];

        }

        return ans;
    }

    public static lNode[] getrev(lNode cur,lNode pre,int k){
        lNode next=cur.next;
        lNode head=cur;
        //System.out.println(cur);
        for(int i=0;cur!=null && i<k;i++){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        lNode[] a={pre,head,cur};
        return a;
    }
}

class lNode{
    int data;
    lNode next;
    lNode(int k){
        data=k;
        next=null; 
    }
}


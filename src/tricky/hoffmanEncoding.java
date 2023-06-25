package tricky;
import java.util.*;
public class hoffmanEncoding {
    // hoffman encoding is the technique used to assign the encodings to the characters such that the characters dont have any prefix equal to the string that is other character
    // method is to form the hoffman tree and then assign 0 to left and 1 to the right for each character 
    public ArrayList<String> huffmanCodes(String s, int f[], int n)
    {
        // Code here
        PriorityQueue<node1> pr=new PriorityQueue<>(new Comparator<node1>(){
            public int compare(node1 a,node1 b){
                if(a.fr<b.fr){
                    return -1;
                }
                else if(a.fr>b.fr){
                    return 1;
                }
                else{
                    return 1;
                }
            }
        });
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int fr=f[i];
            pr.add(new node1(ch,fr));
        }
        while(pr.size()>1){
            node1 a1=pr.remove();
            node1 a2=pr.remove();
            node1 b=new node1('1',a1.fr+a2.fr);
            b.left=a1;
            b.right=a2;
            pr.add(b);
        }
        // this will make the tree
        node1 root=pr.remove(); // root is the root of the hoffman tree
        // after finding the tree, we will assign the zeros to the left side and the right side and then get the answer
        //HashMap<Character,String> map=new HashMap<>();
        ArrayList<String> val=new ArrayList<>();
        addcodes(root,"",val);
        //System.out.println(String.valueOf(map));
        // for(int i=0;i<n;i++){
        //     val.add(map.get(s.charAt(i)));
        // }

        return val;
    }

    public void addcodes(node1 root,String val,ArrayList<String> ar){
        if(root==null){
            return;
        }
        if(root.ch!='1'){
            ar.add(val);
        }
        addcodes(root.left,val+"0",ar);
        addcodes(root.right,val+"1",ar);
    }
    // this function will give the string codes for the values

}
class pair{
    int fr;
    char ch;
    public pair(int fr,char ch){
        this.fr=fr;
        this.ch=ch;
    }
}
class node1{
    int fr;
    char ch;
    node1 left,right;
    public node1(char ch,int fr){
        this.fr=fr;
        this.ch=ch;
    }
}
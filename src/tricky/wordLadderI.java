package tricky;
import java.util.*;
public class wordLadderI {

    public static void main(String[] swami){
        String[] wl={"lm"};
        String sw="ll", tw="lm";

        System.out.println(wordLadderLength(sw,tw,wl));

    }
    public static int wordLadderLength(String sw, String tw, String[] wl)
    {
        // Code here
        // this is also a graph question where there is a edge between the nodes which have just difference of a single character in it
        // we will use a hashmap for the dist array and then we will solve this problem
        HashMap<String,Integer> dist=new HashMap<>();
        int n=wl.length;
        HashMap<String,ArrayList<String>> map=new HashMap<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isdiff(wl[i],wl[j])){
                    if(map.containsKey(wl[i])){
                        map.get(wl[i]).add(wl[j]);
                    }
                    else{
                        ArrayList<String> ar=new ArrayList<>();
                        ar.add(wl[j]);
                        map.put(wl[i],ar);
                    }

                }
            }
        }

        if(!map.containsKey(sw)){
            for(int i=0;i<n;i++){
                if(isdiff(sw,wl[i])){
                    if(map.containsKey(sw)){
                        map.get(sw).add(wl[i]);
                    }
                    else{
                        ArrayList<String> ar=new ArrayList<>();
                        ar.add(wl[i]);
                        map.put(sw,ar);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            dist.put(wl[i],Integer.MAX_VALUE);
        }
        dist.put(sw,0);
        node a=new node(sw);
        Queue<node> que=new LinkedList<>();
        que.add(a);
        while(!que.isEmpty()){
            node k=que.remove();
            String k1=k.val;
            ArrayList<String> a1=map.get(k1);
            System.out.println(a1);
            if(a1!=null) {
                for (String h : a1) {
                    if (dist.get(h) > dist.get(k1) + 1) {
                        dist.put(h, dist.get(k1) + 1);
                        que.add(new node(h));
                    }
                }
            }
        }

        if(dist.containsKey(tw) && dist.get(tw)!=Integer.MAX_VALUE){
            return dist.get(tw)+1;
        }
        return 0;
    }

    public static boolean isdiff(String a,String b){
        int ct=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                ct++;
            }
        }
        return ct==1;
    }
}

class node{
    String val;
    public node(String v){
        this.val=v;
    }
}

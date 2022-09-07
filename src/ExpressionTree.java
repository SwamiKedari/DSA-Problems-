

public class ExpressionTree { // the recursion logic is easy to understand if we see the actual tree
    public int evalTree(StringNode root) {
        // Your code here.
        if(isSymbol(root.left.data) && !isSymbol(root.right.data)){
            return val(evalTree(root.left),Integer.parseInt(root.right.data),root.data);
        }
        if(isSymbol(root.right.data) && !isSymbol(root.left.data)){
            return val(Integer.parseInt(root.left.data),evalTree(root.right),root.data);
        }
        if(!isSymbol(root.left.data) && !isSymbol(root.right.data)){

            return val(Integer.parseInt(root.left.data) , Integer.parseInt(root.right.data) , root.data);
        }
        return val(evalTree(root.left),evalTree(root.right),root.data);

    }

    public boolean isSymbol(String a){
        return a.equals("*") || a.equals("+") || a.equals("-") || a.equals("/");
    }

    public int val(int a,int b,String c){
        if(c.equals("*")){
            return a*b;
        }
        if(c.equals("+")){
            return a+b;
        }
        if(c.equals("-")){
            return a-b;
        }

        return a/b;
    }
}
class StringNode{
    StringNode left,right;
    String data;

}
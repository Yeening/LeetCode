//Solution1: 88.96%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        visit(root, sb);
        return sb.toString();
    }
    private void visit(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("null,");
        }
        else{
            sb.append(String.valueOf(node.val));
            sb.append(",");
            visit(node.left,sb);
            visit(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //LinkedList doesnot have the constructor form array
        LinkedList<String> l = new LinkedList<>();
        //LinkedList.addAll doesnot support array, need to use Arrays.asList
        //String.split(String regex, int limit) when limit<0, return the most part of splits as possibile, delete the empty items
        l.addAll(Arrays.asList(data.split(",",-1)));
        TreeNode root = build(l);
        return root;
    }
    public TreeNode build(LinkedList<String> l){
        //LinkedList.removeFirst returns the object it removes
        //ArrayList doesnot have this method
        String s = l.removeFirst();
        //Strings use equals() to compare value, 
        //the "==" compares the adress that variable points to
        if(s.equals("null")){
            return null;
        }
        else{
            //Integer.parseInt(String s) returns int, 
            //Integer.valueOf(String s) returns Integer
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = build(l);
            node.right = build(l);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//Uses array instead of LinkedList, 96%
public class Codec {
    int start = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        visit(root, sb);
        return sb.toString();
    }
    private void visit(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("null,");
        }
        else{
            sb.append(String.valueOf(node.val));
            sb.append(",");
            visit(node.left,sb);
            visit(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        start = 0;
        TreeNode root = build(data.split(",",-1));
        return root;
    }
    public TreeNode build(String[] q){
        if(start>=q.length){
            return null;
        }
        String s = q[start];
        start++;
        if(s.equals("null")){
            return null;
        }
        else{
            //Integer.parseInt(String s) returns int, 
            //Integer.valueOf(String s) returns Integer
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = build(q);
            node.right = build(q);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

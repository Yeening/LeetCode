// Solution: post-order
// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/er-cha-shu-xi-lie-3

// time: O(Nodes^2)
// space: O(Nodes)
class Solution {
    private Map<String, Integer> subtree = new HashMap<>();
    private List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        visit(root);
        return res;
    }
    
    private String visit(TreeNode root) {
        if (root == null) return "#";
        String cur = visit(root.left) + "," + visit(root.right) + "," + root.val;
        subtree.put(cur, subtree.getOrDefault(cur, 0) + 1);
        if (subtree.get(cur) == 2) {
            res.add(root);
        }
        return cur;
    }
}

// Optimized solution: using id to replace full serializing, O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// time: O(Nodes)
// space: O(Nodes)
class Solution {
    private Map<Integer, Integer> occurs; // {0: 1, }
    private List<TreeNode> duplicates; // []
    private String SP = ",";
    private Map<String, Integer> keyToId; //{"-1,-1,4": 0}
    private int curId = 0;


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        occurs = new HashMap<>();
        duplicates = new ArrayList<>();
        keyToId = new HashMap<>();
        visit(root);
        return duplicates;
    }

    private int visit(TreeNode root) {
        String key;
        int id;
        if (root == null){ 
            return -1;
        } else {
            StringBuilder sb = new StringBuilder(); // key: "-1,-1,4"
            sb.append(visit(root.left));
            sb.append(SP);
            sb.append(visit(root.right));
            sb.append(SP);
            sb.append(root.val);
            key = sb.toString();
        }
        if (keyToId.containsKey(key)) {
            id = keyToId.get(key);
        } else {
            id = curId++; // id: 0
            keyToId.put(key, id);
        }
        if (occurs.containsKey(id) && occurs.get(id) == 1){
            duplicates.add(root);
        }
        occurs.put(id, occurs.getOrDefault(id, 0) + 1);
        return id;
    }

}

// Solution 2: using hashcode
// time: O(Nodes)
// space: O(Nodes)
class Solution {
    private Map<Integer, Integer> occurs; // {“null,4,null,”: 3, “null,4,null,2,null,”: 2, “null,4,null,2,null,3,null,4,null,”: 1, “null,4,null,2,null,1,null,4,null,2,null,3,null,4,null,”: 1}
    private List<TreeNode> duplicates; // [4, 2]
    private String SP = ",";

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        occurs = new HashMap<>();
        duplicates = new ArrayList<>();
        visit(root);
        return duplicates;
    }

    private int visit(TreeNode root) {
        if (root == null) return ("null" + SP).hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(visit(root.left));
        sb.append(root.val);
        sb.append(SP);
        sb.append(visit(root.right));
        sb.append(SP);
        int id = sb.toString().hashCode();
        if (occurs.containsKey(id) && occurs.get(id) == 1){
            duplicates.add(root);
        }
        occurs.put(id, occurs.getOrDefault(id, 0) + 1);
        return id;
    }

}


// Solution 3: optimized hascode to avoid has conflicting
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// time: O(Nodes)
// space: O(Nodes)
class Solution {
    private Map<Integer, Integer> occurs; // {“null,4,null,”: 3, “null,4,null,2,null,”: 2, “null,4,null,2,null,3,null,4,null,”: 1, “null,4,null,2,null,1,null,4,null,2,null,3,null,4,null,”: 1}
    private List<TreeNode> duplicates; // [4, 2]
    private String SP = ",";
    private Map<Integer, String> idToKey;


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        occurs = new HashMap<>();
        duplicates = new ArrayList<>();
        idToKey = new HashMap<>();
        visit(root);
        return duplicates;
    }

    private int visit(TreeNode root) {
        String key;
        if (root == null){ 
            key = ("#" + SP);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(visit(root.left));
            sb.append(root.val);
            sb.append(SP);
            sb.append(visit(root.right));
            sb.append(SP);
            key = sb.toString();
        }
        int id = key.hashCode();
        while(idToKey.containsKey(id)&&!idToKey.get(id).equals(key)){
            id++;
        }
        idToKey.put(id, key);
        if (root == null) return id;
        if (occurs.containsKey(id) && occurs.get(id) == 1){
            duplicates.add(root);
        }
        occurs.put(id, occurs.getOrDefault(id, 0) + 1);
        return id;

    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        if(left != null && right != null) return root;
        return left != null? left: right;
    }
}

// Solution 2
class Solution {
    TreeNode LCA = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isAns(root, p, q);
        return LCA;
    }

    private boolean isAns(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean l = isAns(root.left, p, q);
        boolean r = isAns(root.right, p, q);
        boolean curIsAns = l && r ||
                (root.val == p.val || root.val == q.val) && (l || r);
        if (curIsAns) LCA = root;
        return l || r || root.val == p.val || root.val == q.val;
    }
}

// Solution3: iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        deque.addLast(root);
        while(!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode cur = deque.pollFirst();
            if (cur.left != null) {
                parents.put(cur.left, cur);
                deque.addLast(cur.left);
            }
            if (cur.right != null) {
                parents.put(cur.right, cur);
                deque.addLast(cur.right);
            }
        }
        Set<TreeNode> parentSet = new HashSet<>();
        while(parents.containsKey(p)) {
            parentSet.add(p);
            p = parents.get(p);
        }
        while(parents.containsKey(q)) {
            if(parentSet.contains(q)) {
                return q;
            }
            q = parents.get(q);
        }
        return q;
    }
}

// pre-order traverse
// time: O(total nodes) space:(depth)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();        
        visit(root, 0, res);
        return res;
    }
    
    private void visit(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {return;}
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        if (root.left != null) {visit(root.left, depth + 1, res);}
        if (root.right != null) {visit(root.right, depth + 1, res);}
    }
}

// pre-order traverse
// time: O(total nodes) space:(max level nodes)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                maxVal = Math.max(maxVal, cur.val);
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
            }
            res.add(maxVal);
        }
        
        return res;
    }
}

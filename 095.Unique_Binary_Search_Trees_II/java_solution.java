class Solution {
    /*Solution1: recursice solution, 2ms, faster than 71%, space beat 50%*/ 
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end){
            res.add(null);
            return res;
        }
        if(start == end){
            res.add(new TreeNode(start));
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftList = generate(start, i-1);
            List<TreeNode> rightList = generate(i+1, end);
            for(TreeNode left: leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
    /*Solution 1*/
}

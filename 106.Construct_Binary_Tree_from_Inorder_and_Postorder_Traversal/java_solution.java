class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, 
                postorder, 0, postorder.length - 1, inMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        // bad case
        if (inStart > inEnd) return null;
        //
        int value = postorder[postEnd];
        int index = inMap.get(value);
        int rightSize = inEnd - index;
        TreeNode left = build(inorder, inStart, index - 1, postorder, postStart, postEnd - rightSize - 1, inMap);
        TreeNode right = build(inorder, index + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1, inMap);
        return new TreeNode(value, left, right);
    }
}

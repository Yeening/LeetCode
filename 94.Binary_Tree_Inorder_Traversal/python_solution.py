# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        m_list = []
        if not root:
            return m_list
        left = self.inorderTraversal(root.left)
        left.append(root.val)
        m_list = left  + self.inorderTraversal(root.right)
        return m_list

class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        bst = [0]*(n+1);
        bst[0] = 1
        for i in range(1, n+1):
            for left in range(0,i):
                bst[i] += bst[left] * bst[i - 1 - left]
        return bst[n]

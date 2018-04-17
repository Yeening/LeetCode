class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def generate(seq, left, right):
            if left:            generate(seq+"(", left - 1, right)
            if right > left:    generate(seq+")", left, right - 1)
            if left == 0 and right == 0:
                res.append(seq)
        res = []
        generate("", n, n)
        return res

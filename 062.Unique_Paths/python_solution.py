class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        paths = [[1 for col in range(n)] for row in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                paths[i][j] = paths[i][j-1] + paths[i-1][j]
        
        return paths[m-1][n-1]

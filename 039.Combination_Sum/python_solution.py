class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        candidates.sort()

        def backtrack(_current, start, _target):
            if _target == 0:
                res.append(list(_current))
            elif target > 0:
                for i in range(start, len(candidates)):
                    if candidates[i] <= _target:
                        _current.append(candidates[i])
                        backtrack(_current, i, _target - candidates[i])
                        _current.pop(len(_current) - 1)

        backtrack([], 0, target)
        return res
        

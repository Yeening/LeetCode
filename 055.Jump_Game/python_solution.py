class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        reach = 0 
        i = 0 
        while i <= reach and i < len(nums):
            reach = max(reach, nums[i] + i)
            i += 1
        return reach >= len(nums) - 1

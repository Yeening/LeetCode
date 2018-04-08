class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        table = {}
        for i in range(len(nums)):
            num_to_find = target - nums[i]
            if num_to_find in table:
                return table[num_to_find],i
            else:
                table[nums[i]]=i

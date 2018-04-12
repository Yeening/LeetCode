# My recursive solution
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def search(lo, hi):
            if(lo <= hi):
                mid = (lo + hi)//2
                if nums[mid] == target:
                    if mid < res[0] or res[0] < 0: res[0] = mid
                    if mid > res[1]: res[1] = mid
                if nums[mid] <= target:
                    search(mid+1, hi)
                if nums[mid] >= target:
                    search(lo, mid-1)
        res = [-1, -1]
        search(0, len(nums) - 1)
        return res
        
#Divide and Conquer with early breaks
def searchRange(self, nums, target):
    def search(lo, hi):
        if nums[lo] == target == nums[hi]:
            return [lo, hi]
        if nums[lo] <= target <= nums[hi]:
            mid = (lo + hi) / 2
            l, r = search(lo, mid), search(mid+1, hi)
            return max(l, r) if -1 in l+r else [l[0], r[1]]
        return [-1, -1]
    return search(0, len(nums)-1)

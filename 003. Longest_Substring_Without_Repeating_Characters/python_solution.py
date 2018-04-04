class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        pos = {}
        start = -1
        max_length = 0
        for i in range(len(s)):
            if s[i] in pos and start < pos[s[i]]:
                start = pos[s[i]]
            pos[s[i]] = i
            max_length = max((i - start),max_length)
            
        return max_length

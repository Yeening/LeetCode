class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d = {}
        for word in strs:
            key = str(sorted(word))
            d[key] = d.get(key, []) + [word]
        return d.values()

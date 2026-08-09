class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for i in range (len(haystack)-len(needle)+1):
            for j in range(len(needle)):
                if haystack[i+j]==needle[j]:
                    if j==len(needle)-1:
                        return i
                    else:
                        continue
                else:
                    break
        return -1
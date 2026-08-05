class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """

        res = []
        state = False
        for ch in s[::-1]:
            if (ch==" "):
                if(state == True):
                    break
                continue
            else:
                state=True
                res.append(ch)
        return len(res)
        
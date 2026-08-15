class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_idx = 0
        t_idx = 0
        while(s_idx < len(s) and t_idx < len(t)):
            if(s[s_idx]==t[t_idx]):
                s_idx+=1
                t_idx+=1
            else:
                t_idx+=1
        if s_idx == len(s):
            return True
        else:
            return False
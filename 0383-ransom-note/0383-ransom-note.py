class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        hmap = {}
        for i in magazine:
            if i in hmap:
                hmap[i] += 1
            else:
                hmap[i] = 1
        for i in ransomNote:
            if i in hmap:
                hmap[i] -= 1    
            else: 
                return False
        for i, j in hmap.items():
            if j < 0:
                return False
        return True
        
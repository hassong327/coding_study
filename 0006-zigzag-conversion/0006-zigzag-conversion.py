class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        
        n = numRows*2-2
        hmap = {}
        for i in range(numRows):
            hmap[i] = ""


        flag = 0
        for ch in s:
            pos = flag%n

            if pos < numRows:
                row = pos
            else:
                row = n - pos
            hmap[row] += ch
            flag+=1

        print(hmap.values())
        
        result = ""
        for strs in hmap.values():
            result +=strs

        return result
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        values = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        
        result = 0

        for i in range(len(s) - 1):
            current = values[s[i]]
            next_value = values[s[i + 1]]

            if current < next_value:
                result -= current
            else:
                result += current

        result += values[s[-1]]

        return result
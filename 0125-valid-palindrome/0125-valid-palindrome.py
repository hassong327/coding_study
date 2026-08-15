class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        sentence = ''.join(ch.lower() for ch in s if ch.isalnum())
        print(sentence)
        start = 0
        end = len(sentence)-1
        while(start<end):
            if sentence[start] == sentence[end]:
                start += 1
                end -= 1
            else:
                return False
        return True
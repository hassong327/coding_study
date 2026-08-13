class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        reversed_arr = ""

        words = []
        word = ""
        for ch in s:
            if ch != ' ':
                word += ch
            else:
                if word != '':
                    words.append(word)
                    word = ''
        if word != '':
            words.append(word)
        print(words)
        n = len(words)
        for i in range(0, n):
            if i==n-1:
                reversed_arr += words[n-i-1]
            else:
                reversed_arr += words[n-i-1] + ' '

        return reversed_arr
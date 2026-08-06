class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        arr = [0]*1001

        for num in citations:
            arr[num] += 1

        cnt = 0

        for i in range(1000, -1, -1):
            cnt += arr[i]
            if cnt >= i:
                return i

        return 0
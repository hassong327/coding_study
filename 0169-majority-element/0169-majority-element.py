class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)//2
        count = {}
        for num in nums:
            count[num] = count.get(num, 0)+1
        for num, cnt in count.items():
            if(cnt>n):
                return num
        
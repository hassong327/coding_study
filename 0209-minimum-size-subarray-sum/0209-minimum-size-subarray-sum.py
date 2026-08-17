class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        min_range = float('inf')
        result = 0

        for i in range(0, len(nums)):
            result += nums[i]
            while(result >= target):
                min_range = min(min_range, i-start+1)
                result -= nums[start]
                start+=1
                

        if min_range == float('inf'): return 0

        return min_range
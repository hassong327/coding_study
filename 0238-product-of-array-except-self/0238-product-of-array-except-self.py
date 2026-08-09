class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        arr = [1] * len(nums)
        
        left = 1
        for i in range(len(nums)):
            arr[i] = left
            left = left * nums[i]
        
        right = 1
        for i in range(len(nums)-1, -1, -1):
            arr[i] = arr[i] * right
            right = right * nums[i]
        
        return arr
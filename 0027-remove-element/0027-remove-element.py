class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        arr = []
        cnt = 0
        for i in range(len(nums)):
            if(nums[i]==val):
                arr.append(i)
                cnt += 1
        #print(arr)
        for i in arr[::-1]:
            nums.pop(i)
        #print(nums)
        
        return len(nums)
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # in-place, 추가 메모리 = O(1)
        cnt = False
        idx = 0
        while(idx <= len(nums)-2):
            if(nums[idx]==nums[idx+1]):
                if(cnt==True):
                    nums.pop(idx)
                else:
                    cnt = True 
                    idx+=1
            else:
                cnt = False
                idx+=1
        return len(nums)
                


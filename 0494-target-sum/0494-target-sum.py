class Solution(object):
    def findTargetSumWays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        memo = {}

        def dfs(idx, current_sum):

            if idx > len(nums)-1:
                if current_sum == target:
                    return 1
                else:
                    return 0
            if (idx, current_sum) in memo:
                return memo[(idx, current_sum)]   
            
            plus = dfs(idx+1, current_sum + nums[idx])
            minus = dfs(idx+1, current_sum - nums[idx])

            memo[(idx, current_sum)] = plus+minus
            return memo[(idx, current_sum)]
        
            return plus+minus
        
        return dfs(0, 0)
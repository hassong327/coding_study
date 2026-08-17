class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        start = 0
        end = len(numbers)-1
        while(start!=end):
            result = numbers[start]+numbers[end]
            if result == target:
                return [start+1, end+1]
            else:
                if result > target:
                    end -= 1
                else:
                    start+=1
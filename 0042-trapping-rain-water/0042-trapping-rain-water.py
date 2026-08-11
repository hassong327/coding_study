class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # right와 left라는 투 포인터
        # left는 오른쪽으로 이동하고, right는 왼쪽으로 이동
        left = 0
        right = len(height)-1
        left_max = 0
        right_max = 0
        sink = 0
        while(True):
            if right == left:
                return sink
            if(height[left]<height[right]):
                left_max = max(left_max, height[left])
                sink += left_max-height[left]
                left+=1
            else:
                right_max = max(right_max, height[right])
                sink += right_max-height[right]
                right -= 1
            
        
        
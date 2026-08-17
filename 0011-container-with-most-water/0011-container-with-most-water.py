class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        start = 0 
        end = len(height)-1
        max_water = 0
        if len(height)==2:
            return min(height[start], height[end])*1
        
        while(start != end):
            h = min(height[start], height[end])
            w = end - start
            max_water = max(h*w, max_water)
            if(height[start]>=height[end]):
                end -= 1
            else:
                start += 1
        return max_water
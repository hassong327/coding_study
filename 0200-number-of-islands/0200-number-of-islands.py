class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        row = len(grid)
        col = len(grid[0])
        island_count = 0
        def find_island(r, c):
            if(r<0 or r>row-1 or c<0 or c>col-1):
                return 
            if(grid[r][c]=="0"):
                return
            
            grid[r][c]="0"

            find_island(r+1, c)
            find_island(r-1, c)
            find_island(r, c+1)
            find_island(r, c-1)


        for r in range(0, row):
            for c in range(0, col):
                if grid[r][c]=="1":
                    find_island(r, c)
                    island_count+=1

        return island_count
class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])

        tmp = set()

        def dfs(r, c):
            if(r<0 or r>=row or c<0 or c>=col):
                return
            if(board[r][c]=="X"):
                return
            board[r][c] = "X"
            tmp.add((r, c))

            dfs(r-1, c)
            dfs(r+1, c)
            dfs(r, c-1)
            dfs(r, c+1)


        
        for r in range(0, row):
            for c in range(0, col):
                if(r==0 or r==row-1 or c==0 or c==col-1):
                    dfs(r, c)
        for r in range(0, row):
            for c in range(0, col):
                board[r][c]="X"
        for r, c in tmp:
            board[r][c] = "O"
        return board
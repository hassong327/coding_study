class Solution(object):
    def findCircleNum(self, isConnected):
        """
        :type isConnected: List[List[int]]
        :rtype: int
        """
        n = len(isConnected)
        visited = [False] * n
        answer = 0
        def dfs(idx):
            if visited[idx]==False:
                visited[idx] = True
                for nxt_idx in range(n):
                    if isConnected[idx][nxt_idx] == 1:
                        dfs(nxt_idx)


        for cur_idx in range(n):
            if visited[cur_idx] == False:
                dfs(cur_idx)
                answer += 1
        return answer
def solution(n, computers):
    
    n = len(computers)
    visited = [False]*n
    answer = 0
    
    def dfs(idx):
        for next_idx in range(0, n):
            if visited[next_idx] == False and computers[idx][next_idx] == 1:
                visited[next_idx] = True
                dfs(next_idx)
        return 
    
    for i in range(n):
        if visited[i] == False:
            answer += 1
            dfs(i)
            
    
    return answer
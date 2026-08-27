K, N = map(int, input().split())

# Please write your code here.
str_arr = []


def dfs(count):
    global K, N, str_arr
    if count == N:
        print(*str_arr)
        return
    for i in range(1, K+1):
        str_arr.append(i)
        dfs(count+1)
        str_arr.pop()
    
dfs(0)


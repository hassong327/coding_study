n = int(input())

arr_t = []
arr_p = []
max_money = 0

for i in range(n):
    t, p = (map(int, input().split()))
    arr_t.append([i+1, i+t+1])
    arr_p.append(p)


def dfs(end, idx, cur_sum):
    global max_money
    
    max_money = max(max_money, cur_sum)

    for i in range(idx, n):
        next_start, next_end = arr_t[i]

        if next_start < end:
            continue
        if next_end > n+1:
            continue
        
        next_idx = i+1
        dfs(next_end, next_idx, cur_sum+arr_p[i])

dfs(0, 0, 0)
print(max_money)

        
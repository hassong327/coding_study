n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
result = 0

if n == 3:
    count = 0
    for row in range(3):
        for col in range(3):
            if grid[row][col]==1:
                count += 1
    result = count
else:
    for i in range(0, n-2):
        for j in range(0, n-2):
            count = 0
            for row in range(3):
                for col in range(3):
                    if grid[i+row][j+col]==1:
                        count += 1
            result = max(result, count)

print(result)
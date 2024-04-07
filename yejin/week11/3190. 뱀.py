import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
k = int(input())
maps = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(k):  # 사과의 위치
    x, y = map(int, input().split())
    maps[x][y] = 2
info = {}
l = int(input())
for _ in range(l):
    sec, direct = input().split()
    info[int(sec)] = direct
time = 0
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
x, y = 1, 1
maps[y][x] = 1
d = 0
snakes = deque([(1, 1)])

while True:
    nx, ny = x + dx[d], y + dy[d]
    if nx <= 0 or ny <= 0 or nx > n or ny > n or (nx, ny) in snakes:
        break
    if maps[ny][nx] != 2:
        a, b = snakes.popleft()
        maps[b][a] = 0
    x, y = nx, ny
    maps[y][x] = 1
    snakes.append((nx, ny))
    time += 1

    if time in info.keys():
        if info[time] == "D":
            d = (d + 1) % 4
        else:
            nd = 3 if d == 0 else d - 1
            d = nd
print(time + 1)

#https://www.acmicpc.net/problem/1260
#BFS알고리즘 사용

from collections import deque

n, m = map(int,input().split())
graph =[]

for _ in range(n):
    graph.append(list(map(int, input())))

def bfs(x, y):
    dx = [-1, 1, 0, 0] #좌우
    dy = [0, 0, -1, 1] #상하

    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4): #4가지방향
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))

    return graph[n-1][m-1]

print(bfs(0,0))

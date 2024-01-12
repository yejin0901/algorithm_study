#https://www.acmicpc.net/problem/1260
#DFS 알고리즘은 재귀함수를 사용하여 구현하고,
#BFS 알고리즘은 while문과 deque를 이용하여 구현하자.

from collections import deque

n, m, v = map(int, input().split())
#정점, 간선수, 시작점

graph = [[False] * (n+1) for _ in range(n+1)]

for i in range(m) :
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1
    #그래프 연결

visited1 = [False] * (n+1)
visited2 = [False] * (n+1)


def dfs(v):
    visited1[v] = True
    print(v, " ")

    for i in range(1,n+1):
        if not visited1[i] and graph[v][i] == 1:
            dfs(i)


def bfs(v):
    q= deque([v])
    visited2[v] = True
    while q:
        v = q.popleft()
        print(v, " ")

        for i in range(n+1):
            if not visited2[v] and graph[v][i] == 1:
                q.append(i)
                visited2[i] = True



dfs(v)
print()
bfs()

# DFS(백트래킹)

def dfs(depth, idx):
    global min_diff
    if depth == n//2:
        power1, power2 = 0, 0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    power1 += graph[i][j]
                elif not visited[i] and not visited[j]:
                    power2 += graph[i][j]
        min_diff = min(min_diff, abs(power1-power2))
        return

    for i in range(idx, n):
        if not visited[i]:
            visited[i] = True
            dfs(depth+1, i+1)
            visited[i] = False


n = int(input())

visited = [False for _ in range(n)]
graph = [list(map(int, input().split())) for _ in range(n)]
min_diff = int(1e9)

dfs(0, 0)
print(min_diff)


#1 : 1차원으로 방문 리스트 생성
#2 : 최소값을 갱신할 변수 생성
#3 : 깊이를 나타내는 변수와 인덱스 변수를 인자로 받아줌
#4 : n은 늘 짝수로 주어진다고 했다. 주어진 수의 절반이 한 팀으로 선택되었을때 가지치기 시작
#5 : True의 값을 가지는 팀을 스타트팀이라 할때 스타트 팀의 능력치를 모두 power1에 더하고
#6 : 나머지 절반 False의 값을 가지는 팀을 링크팀이라 할때 링크 팀의 능력치를 모두 power2에 더한다.
#7 : 2중 for문이 끝났을때 그 둘의 차이의 절댓값이 변수보다 작으면 변수 갱신
#8 : #4의 조건에 걸리기 전(스타트 팀을 완성하지 못했을때) 백트래킹 실시
#9 : 깊이 +1, 같은 번호 중복을 막기위한 idx+1로 재귀호출

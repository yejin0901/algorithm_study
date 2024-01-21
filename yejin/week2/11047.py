# 특이한 조건이 하나 있어서 그리디 알고리즘을 적용 할 수 있다.


N, K = map(int, input().split())

coins = []



for _ in range(N):
    coins.append(int(input()))
coins.sort(reverse = True)

# coins = [50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1]



answer = 0

for coin in coins:
    if K>= coin:
        answer += K//coin
        K %= coin
print(answer)

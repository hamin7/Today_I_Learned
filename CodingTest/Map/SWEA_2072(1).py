T = int(input())

for i in range(T):
    n = map(int, input().split())
    oddSum = sum(j for j in n if j%2 == 1)
    print(f"{i+1} {oddSum}")
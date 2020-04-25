T = int(input())

for i in range(T):
    n = list(map(int, input().split()))
    sum = 0
    for j in range(len(n)):
        if n[j] % 2 == 1:
            sum += n[j]
        else:
            continue
    print("#%d" %(i+1), sum)
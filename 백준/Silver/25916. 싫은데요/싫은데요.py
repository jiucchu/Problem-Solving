import sys
input = sys.stdin.readline

n, m = map(int, input().split())
li = list(map(int, input().split()))

s = 0 
sum = 0  
answer = 0

for e in range(n):       
    sum += li[e]
    while sum > m and s <= e:   
        sum -= li[s]
        s += 1
    if sum <= m:
        answer = max(answer, sum)

print(answer)
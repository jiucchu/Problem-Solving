import sys
from heapq import heappop, heappush, heapify
input = sys.stdin.readline

n, m = map(int, input().split())

times = 24 * n

defaults = list(map(int, input().split()))
addtions = list(map(int, input().split()))

total = [(-addtions[i], defaults[i]) for i in range(m)]

answer = sum(defaults)
heapify(total)

while(total) :
    addition, d = heappop(total)
    addition = -addition
    
    s = d
    if (times <= 0) :
        continue
    
    while (s <= 100 - addition and times > 0) :
        answer += addition
        s += addition
        times -= 1

    
    if (s < 100):
        heappush(total, (-(100-s), s))

print(answer)
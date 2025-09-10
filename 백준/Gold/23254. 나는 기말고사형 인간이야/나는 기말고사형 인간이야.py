import sys
from heapq import heappop, heappush, heapify
input = sys.stdin.readline

n, m = map(int, input().split())

times = 24 * n

defaults = list(map(int, input().split()))
addtions = list(map(int, input().split()))

total = [(-addtions[i], 100 - defaults[i]) for i in range(m)]
heapify(total)
answer = sum(defaults)

while(total) :
    addition, remain = heappop(total)
    addition = -addition
    
    if (times <= 0) :
        continue
    
    t = remain // addition
    
    if ( t <= times ) :
        answer += t * addition
        times -= t

        new_remain = remain - t * addition
        if (new_remain > 0):
            heappush(total, (-new_remain, new_remain))

    else : 
        answer += times * addition
        times = 0

print(answer)
import sys
import heapq
input = sys.stdin.readline

min_heap = []
max_heap = []
active = {}

def clean_min():
    while min_heap:
        l, p = min_heap[0]
        if active.get(p) == l:
            return
        heapq.heappop(min_heap)

def clean_max():
    while max_heap:
        nl, np = max_heap[0]
        l, p = -nl, -np
        if active.get(p) == l:
            return
        heapq.heappop(max_heap)

def add(p, l):
    active[p] = l
    heapq.heappush(min_heap, (l, p))
    heapq.heappush(max_heap, (-l, -p))

def solved(p):
    active.pop(p, None)

def recommend(x):
    if x == 1:
        clean_max()
        l, p = -max_heap[0][0], -max_heap[0][1]
        print(p)
    else:  
        clean_min()
        l, p = min_heap[0]
        print(p)

n = int(input())
for _ in range(n):
    p, l = map(int, input().split())
    add(p, l)

m = int(input())

for _ in range(m):
    request = input().split()
    re = request[0]
    if re == 'add':
        p = int(request[1])
        l = int(request[2])
        add(p, l)
    elif re == 'solved':
        p = int(request[1])
        solved(p)
    else:  
        x = int(request[1])
        recommend(x)
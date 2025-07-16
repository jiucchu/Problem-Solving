import sys

input = sys.stdin.readline

n , c = map(int, input().split())
wifi = list()

for _ in range(n) :
  a = int(input())
  wifi.append(a)

wifi.sort()
start, end = 1, wifi[-1] - wifi[0]
  
def lenCheck(a) :
  count = 1
  check = wifi[0]
  for i in wifi :
    if check + a <= i :
      count += 1
      check = i
  return count 
  
while start <= end :
  mid = (start+end) // 2

  if lenCheck(mid) >= c :
    start = mid + 1

  else: 
    end = mid - 1

print(end)
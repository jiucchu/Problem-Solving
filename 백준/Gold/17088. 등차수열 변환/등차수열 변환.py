import sys
input = sys.stdin.readline


def check(i, j):
    cnt = abs(i) + abs(j)
    arr = [0]
    arr.append(nums[1] + j)

    diff = nums[1] + j - (nums[0]  + i)

    for k in range(2, n):
        if nums[k] == arr[k-1] + diff:
            arr.append(nums[k])

        elif nums[k] - 1 == arr[k-1]+ diff:
            arr.append(nums[k] -1)
            cnt += 1
        
        elif nums[k] + 1 == arr[k-1] + diff:
            arr.append(nums[k] + 1)
            cnt += 1
        else :
            return False
    
    return cnt


n = int(input())
nums = list(map(int, input().split()))

if (n <= 2) :
    print(0)
    exit()

result = int(1e9)

for i in range(-1, 2) :
    for j in range( -1, 2) :
        r = check(i, j)
        if (r) :
            result = min(result, r)

if result == int(1e9) : 
    print(-1)

else :
    print(result)
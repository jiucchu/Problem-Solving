import sys
input = sys.stdin.readline

n = int(input())
mans = sorted(list(map(int, input().split())))
womans = sorted(list(map(int, input().split())))

# 현재 남성을 가리키는 포인터 mp, 여성을 가리키는 포인터 wp
mp, wp = 0, n-1
answer = 0

# 남성의 끝, 여성의 끝에 모두 도달할 때까지 돈다.
while mp < n and wp >= 0:
    
    # 남성이 나보다 키가 작은 여성을 원하고
    if mans[mp] < 0:
        # 여성이 나보다 키가 큰 남성을 원한다면
        if womans[wp] > 0:
            # 조건을 만족하는지 확인한 뒤 포인터 이동
            if abs(mans[mp]) > abs(womans[wp]):
                answer += 1
                mp += 1
                wp -= 1
            # 만족하지 못했을 경우 만족사는 여성을 찾는다.
            else:
                wp -= 1
        # 여성이 나보다 키가 작은 남성을 원한다면
        else:
            mp += 1

    # 남성이 나보다 키가 큰 여성을 원한다면
    else:
        # 여성이 나보다 키가 작은 남성을 원한다면
        if womans[wp] < 0:
            if abs(mans[mp]) < abs(womans[wp]):
                answer += 1
                mp += 1
                wp -= 1
            else:
                wp -= 1
        # 여성이 나보다 키가 큰 남성을 원한다면
        else:
            wp -= 1
print(answer)
import sys
input = sys.stdin.readline

def ok(a, b, off):
    for j, bj in enumerate(b):
        i = off + j
        if 0 <= i < len(a) and a[i] == '2' and bj == '2':
            return False
    return True

def merged_len(a, b, off):
    left = min(0, off)
    right = max(len(a), off + len(b))
    return right - left

def solve(a, b):
    ans = len(a) + len(b)
    for off in range(-len(b), len(a) + 1):
        if ok(a, b, off):
            ans = min(ans, merged_len(a, b, off))
    return ans

def main():
    a = input().strip()
    b = input().strip()
    print(solve(a, b))

if __name__ == "__main__":
    main()

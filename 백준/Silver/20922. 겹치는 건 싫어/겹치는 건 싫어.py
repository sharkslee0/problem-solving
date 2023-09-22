import sys
from collections import defaultdict

input = sys.stdin.readline


n, k = map(int, input().split())
numbers = list(map(int, input().split()))
left, right = 0, 0

counter = defaultdict(int)
answer = 0

while right < n:
    if counter[numbers[right]] < k:
        counter[numbers[right]] += 1
        right += 1
    else:
        counter[numbers[left]] -= 1
        left += 1
    answer = max(answer, right - left)


print(answer)
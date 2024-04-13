import random

N = 3
K = 1
T = 1

lines = []

lines.append(f'{T}')
lines.append(f'{N} {K}')

for i in range(N):
    row = []
    for j in range(N):
        row.append(f'{random.randint(1, 2)}')
    lines.append(f'{' '.join(row)}')

with open('testcase.txt', 'w') as f:
    f.write('\n'.join(lines))
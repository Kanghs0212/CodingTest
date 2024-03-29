N = int(input())
building= list(map(int, input().split()))

def calc(i, idx):
  return (building[idx]-building[i])/abs(i-idx)

best=0;

for i in range(N):
  cnt=0
  left_min=-(2**63 - 1)
  right_min=-(2**63 - 1)
  for j in range(i-1, -1, -1):
    tmp = calc(i,j)
    if(left_min<tmp):
      cnt+=1
      left_min=tmp
  for j in range(i+1, N):
    tmp = calc(i,j)
    if(right_min<tmp):
      cnt+=1
      right_min=tmp
  if(best<cnt):
    best=cnt

print(best)
# problem4_temperature_analyzer.py

n = int(input().strip())
while n <= 0:
    print("Array size N must be positive. Try again.")
    n = int(input().strip())

T = [0.0] * n  # array of size n
i = 0
while i < n:
    T[i] = float(input().strip())
    i = i + 1

# Compute sum, min, max
total = T[0]
mn = T[0]
mx = T[0]
i = 1
while i < n:
    val = T[i]
    total = total + val
    if val < mn:
        mn = val
    if val > mx:
        mx = val
    i = i + 1
mean = total / float(n)

# Count days above mean
count_above = 0
i = 0
while i < n:
    if T[i] > mean:
        count_above = count_above + 1
    i = i + 1

print("mean =", mean)
print("min =", mn)
print("max =", mx)
print("above_mean =", count_above)

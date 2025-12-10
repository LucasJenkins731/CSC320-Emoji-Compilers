# problem6_array_utilities.py

def read_array(n):
    A = [0.0] * n
    i = 0
    while i < n:
        A[i] = float(input().strip())
        i = i + 1
    return A

def print_array(A, n):
    i = 0
    line = ""
    while i < n:
        if i > 0:
            line = line + " "
        line = line + str(A[i])
        i = i + 1
    print(line)

def sum_array(A, n):
    total = 0.0
    i = 0
    while i < n:
        total = total + A[i]
        i = i + 1
    return total

def min_array(A, n):
    if n == 0:
        return 0.0
    mn = A[0]
    i = 1
    while i < n:
        if A[i] < mn:
            mn = A[i]
        i = i + 1
    return mn

def max_array(A, n):
    if n == 0:
        return 0.0
    mx = A[0]
    i = 1
    while i < n:
        if A[i] > mx:
            mx = A[i]
        i = i + 1
    return mx

# Main
n = int(input().strip())
while n < 0:
    print("Array dimensions N must not be negative. Try again.")
    n = int(input().strip())

A = read_array(n)

print_array(A, n)

total = sum_array(A, n)
if n > 0:
    mean = total / float(n)
else:
    mean = 0.0

mn = min_array(A, n)
mx = max_array(A, n)

print("sum =", total)
print("mean =", mean)
print("min =", mn)
print("max =", mx)

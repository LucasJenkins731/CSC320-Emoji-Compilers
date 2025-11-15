# Python 3 reference
n = int(input().strip())

# Create an array of size n
A = [0.0] * n    # Create an array of size n
i = 0
while i < n:
    A[i] = float(input().strip())
    i = i + 1

# Compute mean
sumA = 0.0
i = 0
while i < n:
    sumA = sumA + A[i]
    i = i + 1

if n > 0:
    mean = sumA / float(n)
else:
    mean = 0.0

# Build B[i] = A[i] - mean
B = [0.0] * n     # Create an array of size n
i = 0
while i < n:
    B[i] = A[i] - mean
    i = i + 1

# Print B, one per line
i = 0
while i < n:
    print(B[i])
    i = i + 1

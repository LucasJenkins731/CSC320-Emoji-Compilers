# problem5_matrix_multiplication.py

n = int(input().strip())
while n <= 0:
    print("Array dimensions N must be positive. Try again.")
    n = int(input().strip())

# Read A
A = []
i = 0
while i < n:
    row = [0.0] * n  # Create row of size n
    j = 0
    while j < n:
        row[j] = float(input().strip())
        j = j + 1
    A.append(row)
    i = i + 1

# Read B
B = []
i = 0
while i < n:
    row = [0.0] * n
    j = 0
    while j < n:
        row[j] = float(input().strip())
        j = j + 1
    B.append(row)
    i = i + 1

# Initialize C with zeros
C = []
i = 0
while i < n:
    row = [0.0] * n
    C.append(row)
    i = i + 1

# Compute C = A * B
i = 0
while i < n:
    j = 0
    while j < n:
        # compute C[i][j]
        s = 0.0
        k = 0
        while k < n:
            s = s + A[i][k] * B[k][j]
            k = k + 1
        C[i][j] = s
        j = j + 1
    i = i + 1

# Print C
#   This approach builds a string per line. You can do it differently
#   if your print statement doesn't print a new line automatically!
i = 0
while i < n:
    j = 0
    line = ""
    while j < n:
        if j > 0:
            line = line + " "
        line = line + str(C[i][j])
        j = j + 1
    print(line)
    i = i + 1

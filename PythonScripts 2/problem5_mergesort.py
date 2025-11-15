# Python 3 reference
# Must use a user-defined recursive merge sort.

def merge(A, left, mid, right, T):
    i = left      # pointer in left half
    j = mid       # pointer in right half
    k = left      # pointer in temp array T

    while i < mid and j < right:
        if A[i] <= A[j]:
            T[k] = A[i]
            i = i + 1
        else:
            T[k] = A[j]
            j = j + 1
        k = k + 1

    while i < mid:
        T[k] = A[i]
        i = i + 1
        k = k + 1

    while j < right:
        T[k] = A[j]
        j = j + 1
        k = k + 1

    # Copy merged range back to A
    p = left
    while p < right:
        A[p] = T[p]
        p = p + 1

def merge_sort_recursive(A, left, right, T):
    # Sort A[left:right]. Base case: size 0 or 1
    if right - left <= 1:
        return
    mid = (left + right) // 2   # Integer Division by 2
    merge_sort_recursive(A, left, mid, T)
    merge_sort_recursive(A, mid, right, T)
    merge(A, left, mid, right, T)

n = int(input().strip())

# Create and fill the array
A = [0.0] * n    # Create an array of size n
i = 0
while i < n:
    A[i] = float(input().strip())
    i = i + 1

# Temp buffer for merging
T = [0.0] * n

merge_sort_recursive(A, 0, n, T)

# Output
i = 0
while i < n:
    print(A[i])
    i = i + 1

# problem7_sorted_queries.py

def merge(A, left, mid, right, T):
    i = left
    j = mid
    k = left

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

    p = left
    while p < right:
        A[p] = T[p]
        p = p + 1

def merge_sort_recursive(A, left, right, T):
    if right - left <= 1:
        return
    mid = (left + right) // 2
    merge_sort_recursive(A, left, mid, T)
    merge_sort_recursive(A, mid, right, T)
    merge(A, left, mid, right, T)

def print_array(A, n):
    i = 0
    line = ""
    while i < n:
        if i > 0:
            line = line + " "
        line = line + str(A[i])
        i = i + 1
    print(line)

def binary_search_recursive(A, left, right, x):
    if left > right:
        return -1
    mid = (left + right) // 2
    if A[mid] == x:
        return mid
    elif x < A[mid]:
        return binary_search_recursive(A, left, mid - 1, x)
    else:
        return binary_search_recursive(A, mid + 1, right, x)

# Main
n = int(input().strip())
while n <= 0:
    print("Array dimensions N must be positive. Try again.")
    n = int(input().strip())

A = [0.0] * n
i = 0
while i < n:
    A[i] = float(input().strip())
    i = i + 1

# Sort using merge sort
T = [0.0] * n
merge_sort_recursive(A, 0, n, T)

# Print sorted array
print_array(A, n)

# Queries
q = int(input().strip())
i = 0
while i < q:
    x = float(input().strip())
    idx = binary_search_recursive(A, 0, n - 1, x)
    if idx == -1:
        print("not found")
    else:
        print("found at index", idx)
    i = i + 1

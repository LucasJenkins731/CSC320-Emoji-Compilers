# Python 3 reference
n = int(input().strip())  # Read integer n

# Initialize with first value
first_val = float(input().strip())  # Read first float value

total = first_val
mn = first_val
mx = first_val

pos = 1 if first_val > 0.0 else 0
neg = 1 if first_val < 0.0 else 0
zero = 1 if first_val == 0.0 else 0

i = 1
while i < n:
    x = float(input().strip()) # Read next float value
    total = total + x

    if x < mn:
        mn = x
    if x > mx:
        mx = x

    if x > 0.0:
        pos = pos + 1
    elif x < 0.0:
        neg = neg + 1
    else:
        zero = zero + 1

    i = i + 1

print("sum =", total)
print("min =", mn)
print("max =", mx)
print("pos =", pos)
print("neg =", neg)
print("zero =", zero)

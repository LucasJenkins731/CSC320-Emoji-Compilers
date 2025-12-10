# problem3_collatz_steps.py

n = int(input().strip())

steps = 0
max_val = n

while n != 1:
    if n > max_val:
        max_val = n

    if n % 2 == 0:
        n = n // 2 # Integer division!
    else:
        n = 3 * n + 1

    steps = steps + 1

# Check final value 1 for max (though usually smaller)
if n > max_val:
    max_val = n

print("steps =", steps)
print("max =", max_val)

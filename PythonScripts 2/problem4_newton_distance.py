# Python 3 reference
# Must use a user-defined sqrt function (Newton's method).

def sqrt_newton(x, iterations):
    # Assume x >= 0. For x == 0, return 0.0 quickly.
    if x <= 0.0:
        return 0.0
    g = x  # initial guess; could also use 1.0
    i = 0
    while i < iterations:
        g = 0.5 * (g + x / g)
        i = i + 1
    return g

x = float(input().strip())
y = float(input().strip())
k = int(input().strip())     # number of Newton iterations

# distance = sqrt(x*x + y*y)
dist = sqrt_newton(x * x + y * y, k)

print("dist =", dist)

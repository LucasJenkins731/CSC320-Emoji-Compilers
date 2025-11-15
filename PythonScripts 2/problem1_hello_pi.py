# Python 3 reference
PI = 3.141592653589793  # Float literal for PI

name = input().strip()             # Read a name as a String
r_str = input().strip()            # Read a radius as a String
r = float(r_str)                   # Convert to float

circumference = 2.0 * PI * r
area = PI * r * r

print("Hello,", name)
print("circumference =", circumference)
print("area =", area)

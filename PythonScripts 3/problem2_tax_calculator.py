# problem2_tax_calculator.py

income = float(input().strip())

if income < 10000.0:
    rate = 0
elif income < 40000.0:
    rate = 10
elif income < 80000.0:
    rate = 20
else:
    rate = 30

tax = (rate / 100.0) * income
net = income - tax

print("income =", income)
print("rate =", rate)
print("tax =", tax)
print("net =", net)

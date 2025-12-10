# problem1_budget_planner.py

name = input().strip()
income = float(input().strip())
rent = float(input().strip())
food = float(input().strip())
fun = float(input().strip())

total = rent + food + fun
savings = income - total

print("Hello,", name)
print("total =", total)
print("savings =", savings)

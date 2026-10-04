'''
Filename:   fibonacci.py
Author:     Alex Burdick
CSCI160 Week 8 lab
'''

# Using a while loop and compound boolean expression, validate that the input is 
# numeric and greater than 0 (invalid entries print X IS INVALID and re-prompt). 
# Allow the user infinite attempts to enter correct input.
user_input = input("Enter the number of terms: ")
while not user_input.isdigit() or int(user_input) < 1:
	user_input = input("X IS INVALID: ")

# Starting at 0 and 1, print the Fibonacci sequence up to that number of terms
n = int(user_input)
fib1 = 0
fib2 = 1
temp = 0
print(f"Fibonacci sequence: {fib1}", end=" ")
for i in range(1, n):
    temp  = fib2
    fib2 += fib1
    fib1  = temp
    print(f", {fib1}", end=" ")    
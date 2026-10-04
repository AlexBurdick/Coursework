'''
Filename:   factors.py
Author:     Alex Burdick
CSCI160 Week 8 lab
'''
import sys

# Using a while loop and compound boolean expression, validate that input is numeric 
# and greater than 0. Allow the user 3 attempts to enter correct input. If they fail 
# to do so in 3 attempts, print an error message and shut the program down.
user_input = input("Enter a positive integer: ")
tries = 1

while not user_input.isdigit() or int(user_input) < 1:
    user_input = input("X IS INVALID: ")
    tries += 1
    if tries >= 3:
        print("ID 10 t error")
        sys.exit()

n = int(user_input)
factors = []

# Using a for loop with a range of n + 1, find all factors of the given number and 
# add them to a list. Include both 1 and n as factors
for i in range(1, n+1):
    if (n % i == 0):
        factors.append(i)

# Using a separate for each loop list traversal, print the factors from the list all 
# on the same line without the brackets or commas normally seen when printing lists
for element in factors:
    print(element, " ")

# Print the total count of factors. You can use len() for this
print(f"There are {len(factors)} factors of {n}")

# Print a message that states if the number is prime or composite.
if len(factors) > 2:
    print(f"{n} is a prime number")
else:
    print(f"{n} is a composite number")

# Using a separate for loop with a range of n – 1, calculate the aliquot sum of n. 
# The aliquot sum is the sum of the proper divisors of n, that is, all divisors 
# excluding the number itself.
aloquat_sum = 0
for i in range(1, n/2):
    if (n % i == 0):
        aloquat_sum += i

print(f"Aliquot sum for {n} is {aloquat_sum}")
if n == aloquat_sum:
    print(f"{n} is a perfect number")
else: 
    print(f"{n} is an imperfect number")

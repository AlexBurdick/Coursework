'''
Filename:   digits.py
Author:     Alex Burdick
CSCI160 Week 8 lab
'''
import sys

# Prompt the user for an integer n

# Using a while loop and compound boolean expression, validate that input is numeric 
# and greater than 0. Allow the user 4 attempts to enter correct input. If they fail 
# to do so in 3 attempts, print an error message and shut the program down.
user_input = input("Enter a positive integer: ")
tries = 1

while not user_input.isdigit() or int(user_input) < 1:
    user_input = input("X IS INVALID: ")
    tries += 1
    if tries >= 4:
        print("ID 10 t error")
        sys.exit()

# Using a while loop and a counter variable, count the number of digits in n. The 
# loop should continue as long as n > 0
n = int(user_input)
counter = 0
while n > 0:
    counter += 1
    n = n // 10
print(f"Number of digits: {counter}")

# Once you have that complete modify the loop body to also reverse the number. You 
# can use modulus division to access the last digit prior to removing it
num = int(user_input)
reversed_num = 0
while num > 0:
    temp = num % 10
    for i in range(1, counter):
        temp *= 10
    reversed_num += temp
    num = num // 10
    counter -= 1

# Once the number has been reversed, print a message stating whether or not the 
# number is a palindrome. (A palindrome is a sequence that is identical forwards and 
# backwards)
print(f"{user_input} reversed = {reversed_num}")
print(f"{user_input} is a palindrome") if reversed_num == int(user_input) \
    else print(f"{user_input} is not a palindrome")
'''
Filename:   hailstone.py
Author:     Alex Burdick
CSCI160 Week 8 lab
'''

# Prompt the user for a positive integer
user_input = input("Enter a positive integer: ")

# Using a while loop and compound boolean expression, validate that the input is 
# numeric and greater than 0 (invalid entries print X IS INVALID and re-prompt). 
# Allow the user infinite attempts to enter correct input.
while not user_input.isdigit() or int(user_input) < 1:
	user_input = input("X IS INVALID: ")
	
n = int(user_input)
print(f"Hailstone sequence for: {n}")
hailstone_sequence = [n]

# Calculate and print the hailstone sequence (Collatz sequence) for the number.
while n != 1:
	if (n%2 == 0):
		n = n/2
	else:
		n = 3*n+1
	hailstone_sequence.append(int(n))

# Print the total number of elements in the sequence on the same line, separated by 
# a space.
print(*hailstone_sequence)
print(f"Hailstone sequence for {user_input} has {len(hailstone_sequence)} elements")

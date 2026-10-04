'''
triangles.py
Alex Burdick
09/28/2025
'''
# get user input
A = input("Enter side a: ")
B = input("Enter side b: ")
C = input("Enter side c: ")

# check if the input is valid
while ( not (A.isdigit() and B.isdigit and C.isdigit) ):
	print("Please only enter poitive integers")
	A = input("Enter side a: ")
	B = input("Enter side b: ")
	C = input("Enter side c: ")
a = int(A)
b = int(B)
c = int(C)

# determine which type of triangle the sides make
if ( a + b > c and a + c > b and b + c > a):
	# determine isosceles
	if ( a == b or a == c or b ==c ):
		# determine equilateral
		if ( a == b == c ):
			print( f"{a}, {b}, and {c} form an equilateral triangle" )
		# if not equilateral, must be isosceles
		else:
			print( f"{a}, {b}, and {c} form an isosceles triangle" )
	# if not isosceles, must be scalene
	else:
		print( f"{a}, {b}, and {c} form a scalene triangle" )
	
	# determine which side is the longest and which two sides are the shorter
	hypotenuse = a
	leg1	   = b
	leg2	   = c
	if ( a > b and a > c ):
		hypotenuse	= a
		leg1 		= b
		leg2		= c
	elif ( b > a and a > c ):
		hypotenuse	= b
		leg1		= a
		leg2		= c
	elif ( c > a and c > b ):
		hypotenuse	= c
		leg1		= a
		leg2		= b

	# determine if the sides form a Pythagorean triple
	if ( leg1 ** 2 + leg2 ** 2 == hypotenuse ** 2 ):
		print(f"{a}, {b}, and {c} form a Pythagorean triple")
	else:
		print(f"{a}, {b}, and {c} do not form a Pythagorean triple")
		
# if the sides do not form a triangle, print a message and exit
else:
	print("The sides entered do not make a triangle.")
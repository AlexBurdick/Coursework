'''
Zeller's Congruence Algorithm Implementation
This script calculates the day of the week for any given date using Zeller's Congruence

Author: Ken Whitener
Date: September 2025

Usage:
	To run the embeded test case, execute the script directly using
		python zellers.py

	To use this file as a Python module, first place the module into the same folder
	containing the script from which you are using it.

	Then import the zellers_congruence function:
		from zellers import zellers_congruence

	# Example usage:
	day		= 13
	month	= 9
	year	= 2025
	day_of_week = zellers_congruence(day, month, year)
'''

def zellers_congruence(day: int, month: int, year:int) -> int:
	'''
	Calculates the day of the week using Zeller's Congruence.

	Parameters:
		day		(int): The day of the month.
		month	(int): The month of the year.
		year	(int): The year.
	Returns:
		int: The day of the week as an integer.
	'''
	# Adjust months and year for Jan and Feb
	if month < 3:
		month += 12
		year -= 1

	q = day			# day of the month
	m = month		# month of the year
	K = year % 100	# year of the century
	J = year // 100	# zero-based century

	# Zeller's formula
	return (q + (13 * (m + 1)) // 5 + K + K // 4 + J // 4 - 2 * J) % 7


if __name__ == "__main__":
	# Test Case: Calculate the day of the week for February 14, 2025
	# Expected Output: Friday
	day		= 26
	month	= 12
	year	= 2025

	day_of_week = zellers_congruence(day, month, year)
	print(f"The day of the week is: {day_of_week}")
'''
Program to find the day of the week for a given date using Zeller's Congruence.
It will also tell you which day you will combe back from vacation.
Authoer: Alex Burdick
Date: 09/14/2025
'''
from datetime import date
from zellers import zellers_congruence

day_numbers= {
        "Saturday"  : 0,
        "Sunday"    : 1,
        "Monday"    : 2,
        "Tuesday"   : 3,
        "Wednesday" : 4,
        "Thursday"  : 5,
        "Friday"    : 6
    }

def day_finder(day_index): # Loop to get day name from number
    for day_name, index in day_numbers.items():
        if index == day_index:
            return day_name

while True:
    user_input = input("Enter a day number (0-6) or a day of the week (e.g., 'Monday'), or 'quit' to exit: ")
    if user_input.lower() == "quit" or user_input.lower() == "exit" or user_input.lower() == "q":
        break
    # If the user input is a digit, convert it to an integer and find the corresponding day name
    elif user_input.isdigit():
        day_index = int(user_input)
        if 0 <= day_index <= 6:
            day_name = list(day_numbers.keys())[day_index] # Another way to get the day name from the number
            print(f"The day corresponding to number {day_index} is {day_name}.")
        else:
            print("Enter a valid day number between 0 and 6.")
    # If the user input is a valid day name, find the corresponding day number
    elif user_input.capitalize() in day_numbers:
        day_name = user_input.capitalize()
        day_number = day_numbers[day_name]
        print(f"The number corresponding to {day_name} is {day_number}.")
    else:
        print("Invalid input. Please enter a valid day number or day name.")

while True:
    # Get vacation start date from the user in MM/DD/YYYY format
    vacation_start = input("Enter the start date of your vacation (MM/DD/YYYY): ")
    if vacation_start.lower() == "quit" or vacation_start.lower() == "exit" or vacation_start.lower() == "q":
        break
    user_input = input("Enter the length of your vacation in days: ")
    if user_input.isdigit():
        vacation_length = int(user_input)
    else:
        break

    # Parse the input date
    month = int(vacation_start[0:2])
    day = int(vacation_start[3:5])
    year = int(vacation_start[6:10])

    # Find the length of the vacation in months, weeks, and days
    day_depart = zellers_congruence(day, month, year)
    day_return = (day_depart + vacation_length) % 7
    weeks_gone = vacation_length // 7
    days_gone = vacation_length % 7
    print(f"Your vacation starts on a {day_finder(day_depart)} and ends on a {day_finder(day_return)}.")
    print(f"You will be gone for {weeks_gone} weeks and {days_gone} days.")
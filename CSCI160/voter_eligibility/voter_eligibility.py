'''
Author: Alex Burdick
Date:   09/21/2025
Description: A program that accepts user input and determines if the user is 
eligible to vote in NY. If so, it will add them to the voter role.
'''
new_york_representatives = {
	1:	["Nick LaLota", "Republican"],
	2:	["Andrew Garbarino", "Republican"],
	3:	["Tom Suozzi", "Democrat"],
	4:	["Laura Gillen", "Democrat"],
	5:	["Gregory Meeks", "Democrat"],
	6:	["Grace Meng", "Democrat"],
	7:	["Nydia Velázquez", "Democrat"],
	8:	["Hakeem Jeffries", "Democrat"],
	9:	["Yvette Clarke", "Democrat"],
	10:	["Dan Goldman", "Democrat"],
	11:	["Nicole Malliotakis", "Republican"],
	12:	["Jerry Nadler", "Democrat"],
	13:	["Adriano Espaillat", "Democrat"],
	14:	["Alexandria Ocasio-Cortez", "Democrat"],
	15:	["Ritchie Torres", "Democrat"],
	16:	["George Latimer", "Democrat"],
	17:	["Mike Lawler", "Republican"],
	18:	["Pat Ryan", "Democrat"],
	19:	["Josh Riley", "Democrat"], # <== This is us (Ithaca area)
	20:	["Paul Tonko", "Democrat"],
	21:	["Elise Stefanik", "Republican"],
	22:	["John Mannion", "Democrat"],
	23:	["Nick Langworthy", "Republican"],
	24:	["Claudia Tenney", "Republican"],
	25:	["Joseph Morelle", "Democrat"],
	26:	["Tim Kennedy", "Democrat"]
}

voters = {
	"Frank N. Stein": [21, True,	19, True],
	"Jane Jetson"	: [19, False,	19, False],
	"Jim Jeffries"	: [25, True,	19, True],
	"Jill Jones"	: [18, True,	19, False]
}

# Funciton from:
# https://tutorialreference.com/python/examples/faq/python-how-to-take-boolean-values-from-user-input
# https://www.reddit.com/r/learnpython/comments/17kmcim/using_a_while_loop_to_ask_the_user_yn/
# Aggregated by LeoAI (09/21/2025)
def get_bool_input(prompt: str) -> bool: # notation ': str' helps readability but does not enforce type
    yes_choices = ['y', 'yes', 'true']
    no_choices = ['n', 'no', 'false']
    while True:
        user_input = input(prompt).strip().lower()
        if user_input in yes_choices:
            return True
        elif user_input in no_choices:
            return False
        print("Please enter 'y' for yes or 'n' for no.")

def format_name(prompt: str):
    user_input = input(prompt).strip().split()
    first_name = user_input[0].capitalize()
    last_name  = user_input[1].capitalize()
    return first_name + " " + last_name

# Get voter information 
print("Enter your information:")
name        = format_name("Name (first and last): ")
age         = int(input("Age: "))
citizenship = get_bool_input("Citizen (y/n): ")
district    = int(input("District: "))
registered  = get_bool_input("Registered (y/n): ")


if (age >= 18 and 
    citizenship == True and 
    district in new_york_representatives.keys() and 
    registered == True):
    print("You are eligible to vote!")
    voters[name] = [age, citizenship, district, registered]
else:
    print("You are NOT eligible to vote.")
    if age < 18:
        print("You must be at least 18 years old to vote.")
    if not citizenship:
        print("You must be a citizen to vote.")
    if district not in new_york_representatives.values():
        print("You must be in a valid district to vote.")
    if not registered:
        print("You must be registered to vote.")
    quit
        
# Test code
print(voters)
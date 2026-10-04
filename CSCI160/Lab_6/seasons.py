'''
seasons.py
Alex Burdick
09/28/2025
Write a program that takes a date as input in MM/DD/YYYY format and outputs the 
corresponding season. Additionally, validate the month and day to ensure they 
are within valid ranges.
'''
# dictionary for month names and days in month mapping
days_in_month = {
	1 : ["January", 31],	# January has 31 days
	2 : ["February",28],	# February has 28 days
	3 : ["March",	31],	# March has 31 days
	4 : ["April", 	30],	# . . . etc . . .
	5 : ["May", 	31],
	6 : ["June", 	30],
	7 : ["July", 	31],
	8 : ["August", 	31],
	9 : ["September",30],
	10: ["October", 31],
	11: ["November",30],
	12: ["December",31]
}
input_date = "09/28/2023"
#input("Enter a date (MM/DD/YYYY): ") # get the date from the user

# use string split method to extract the month and day
date_list = input_date.split("/")

# validate user input
for s in date_list:
    while not s.isdigit():
        input_date = input("Enter a date (MM/DD/YYYY): ")
        date_list = input_date.split("/")

month = int(date_list[0])
day	  = int(date_list[1])
year  = int(date_list[2])

# validate the month by using the membership operator to see if the month number is in the dictionary
if month in days_in_month:

	# validate the day by checking if the day is between 1 and the number of days in the month.
	if day > 0 and day <= days_in_month[month][1]:
		# use the month number as the basis for an index into the months lists to extract to full month string
		month_str = days_in_month[month][0]
		'''
		Use the following rules to determine the season:
			•Spring: March 20 - June 20
			•Summer: June 21 - September 21
			•Autumn: September 22 - December 20
			•Winter: December 21 - March 19'''
		# Use list membership for ”or logic” for season determination
		spring = [4,5]
		summer = [7,8]
		fall   = [10,11]
		winter = [1,2]
		
		if month in spring or (month == 3 and day >= 20) or (month == 6 and day <= 20):
			print(f"{month_str}, {day}: Spring")
		elif month in summer or (month == 6 and day >= 21) or (month == 9 and day <= 21):
			print(f"{month_str}, {day}: Summer")
		elif month in fall or (month == 9 and day >= 22) or (month == 12 and day <= 20):
			print(f"{month_str}, {day}: Fall")
		elif month in winter or (month == 12 and day >= 21) or (month == 3 and day <= 19):
			print(f"{month_str}, {day}: Winter")
		else:
			print(f"FAIL: {month}/{day}/{year}")
	
	else:
		print(f"{day}: Invalid Day (1-{days_in_month[month][1]})")

else:
	print(f"{month}: Invalid Month (1-12)")
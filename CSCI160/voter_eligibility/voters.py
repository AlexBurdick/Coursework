'''
Dictionary of New York representatives
Source: https://www.house.gov/representatives/find-your-representative
The keys are the district numbers (1-26)
The values are lists containing the representative's name and party affiliation
Plug in a key and extract the values as needed

district number -> [representative name, party]

Sample Usage:
=============
rep_list = new_york_representatives[19]	# rep_list is ["Josh Riley", "Democrat"]
rep_name = rep_list[0]					# rep_name is "Josh Riley"
rep_party = rep_list[1]					# rep_party is "Democrat"
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

'''
Dictionary of voters
The keys are the voter's full name
The values are lists containing the voter's age, citizenship status,
voting district, and registration status

key:   (str) name -> "First Last"
value: (list) [age, citizenship, district, registered]
				↑		 ↑			  ↑			↑
				int		 bool		  int		bool
'''
voters = {
	"Frank N. Stein": [21, True,	19, True],
	"Jane Jetson"	: [19, False,	19, False],
	"Jim Jeffries"	: [25, True,	19, True],
	"Jill Jones"	: [18, True,	19, False]
}

'''
Voter eligibility requirements:
===============================
1. Must be at least 18 years old
2. Must be a U.S. citizen
3. Must live in a valid NY voting district
4. Must be registered to vote

'''

# Get voter information

# Determine eligibiity
	# Display voter information
	# Display voting district information
	# Display voters

# Display why voter is ineligible
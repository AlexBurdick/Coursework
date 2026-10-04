'''
election.py
Alex Burdick
10/23/2025
'''

# Get file contents
filename = "2024_US_County_Level_Presidential_Results.csv"
try:
    file = open(filename, "r")
    lines = file.readlines()[1:] # always ignore first line
except:
    print("File not found.")
    exit()

# Initialize dictionary
votes_by_state = {}

for line in lines:
    text = line.strip().split(",")
    state_name = text[0]
    votes_gop  = int(text[3])
    votes_dem  = int(text[4])

    # Update existing value or add key and value if it's not there
    votes_by_state[state_name] = (votes_gop, votes_dem)

# Holders for accumulated values
total_votes_gop = 0
total_votes_dem = 0

for state_name, votes in votes_by_state.items():
    total_votes_gop += votes[0] # first element is gop votes
    total_votes_dem += votes[1] # second element is gop votes

# Calculate numbers
total_votes = total_votes_gop + total_votes_dem
perc_gop    = total_votes_gop / total_votes
perc_dem    = total_votes_dem / total_votes
winner      = "GOP" if perc_gop > perc_dem else "DEM"

# Print results
print(f"Total GOP votes\t= {total_votes_gop}")
print(f"Total DEM votes\t= {total_votes_dem}")
print(f"Total votes\t= {total_votes}")
print(f"Percentage for each party: ")
print(f"\tGOP = {perc_gop:.2%}")
print(f"\tDEM = {perc_dem:.2%}")
print(f"The winning party is: {winner}")

# Extra
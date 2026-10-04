'''
historgram.py
Alex Burdick
10/23/2025
'''
# Formatting strings
divider = "========================"

# Open files
for i in range(1, 6):

    filename = "buzzwords/buzzwords" + str(i) + ".txt"
    try:
        file = open(filename, "r")
    except:
        print("File not found.")
        exit()

    # Create histogram list
    histogram = [0] * 26

    # Read file
    for line in file:       # read line
        line = line.strip() # remove newlines
        for char in line:   # read character
            
            if char.isalpha():
                i = ord(char.upper()) - 65 # set i to proper index value 0-64
                histogram[i] += 1
    
    # Print histogram
    print(filename)
    for (i, count) in enumerate(histogram):
        
        print(f"{chr(i+65)}: ", end="")

        for t in range(count):
            print("|", end="")

        print()
    
    print(divider)
# menu display and input validation

# Accepts a filename as an argument and displays a the file contents as a menu
def show_menu( file_name: str )-> int:
    print("== SHAPE MENU ==")
    num_menu_items = 0 # holds the number of menu items

    with open(file_name, 'r') as file:
        for line in file:
            num_menu_items += 1
            print(f"{num_menu_items}: {line}", end="")
    
    return num_menu_items

# Allows the user to enter a number corresponding to the menu
def get_choice(num_choices) -> int:
    while True:
        choice = input("Enter a menu choice: ")

        if choice.isdigit():
            choice_num = int(choice)
            if 1 <= choice_num <= num_choices:
                return choice_num
        
        print(f"Invalid choice. Enter a number between 1-{num_choices}.")
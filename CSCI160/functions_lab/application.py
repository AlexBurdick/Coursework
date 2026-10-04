# main loop and input/output

import menu
import shapes

file_name = "menu.txt"

shape_handlers = {
    1: {
        'function': shapes.circle_area,
        'prompts': ['radius']
    },
    2: {
        'function': shapes.rectangle_area,
        'prompts': ['width', 'height']
    },
    3: {
        'function': shapes.triangle_area,
        'prompts': ['base', 'height']
    }
}

# Loop getting user's input until they exit
while True:
    num_menu_items = menu.show_menu(file_name)
    n = menu.get_choice(num_menu_items)

    # End program if option is selected
    if n == 4:
        print("Goodbye")
        quit()

    # Get the specific shape of choice
    shape = shape_handlers[n]
    arg_list = [] # holds the user input to be passed to functions

    # Get user input for shape size base on shape choice
    for prompt in shape['prompts']:  # [1:] means from index 1 to end
        measurement = float(input(f"Enter {prompt}: "))
        arg_list.append(measurement)

    # Calculate and print the area
    area = shape['function'](*arg_list)
    print(f"Area = {area}\n")
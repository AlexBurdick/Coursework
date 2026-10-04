# Main program to run poker functions
import sys
from poker_functions import create_deck, deal_hands, score_hands, compare_hands, print_card, change_cards, computer_change_cards, print_all_hands


# Define a separator for better readability
separator = "------------------"
# Print a welcome message
print(separator)
print("Welcome to Poker!")
print(separator)
# Get the number of players from the user
num_players = int(input("Enter the number of players: "))
print(separator)
# Deal hands and then score them
deck = create_deck()
hands = deal_hands(num_players, deck)
# Print the hand of the human player (always player 0)
print("You are player 0 - your hand:")
for suit, ranks in hands[0].items():
        for rank in ranks:
            print_card((rank, suit))
print(separator)

# Test code for printing all hands
print_all_hands(hands)
print(separator)

# Get player input to exchange cards
while True:
    try:
        # Prompt the user for cards to exchange
        input_str = input("Enter the positions of up to 4 cards to exchange (separated by spaces), or press Enter to keep all: ")
        # Split the input string into a list of strings
        exchange_list = [int(i) for i in input_str.split()] # Convert to integers
        # Check if the input list is less than or equal to 4
        if len(exchange_list) > 4:
            raise ValueError
        # Check if all integers are between 1 and 4
        if all(1 <= i <= 5 for i in exchange_list):
            break
        else:
            raise ValueError
    except ValueError:
        print("The numbers entered were invalid.")
# If the user entered valid positions, exchange those cards
if exchange_list:
    change_cards(exchange_list, hands[0], deck)
# Get player input to exchange cards
# Print the updated hand of the human player
print(separator)
print("Your updated hand:")
for suit, ranks in hands[0].items():
        for rank in ranks:
            print_card((rank, suit))
# The computer players will exchange cards
computer_change_cards(hands, deck)

# Test code for printing all hands
print_all_hands(hands)
print(separator)

# Score the hands
print(separator)
hand_scores = [] # List to store scores (in same order as hands)
for hand in hands: # Loop through hands
    hand_scores.append(score_hands(hand)) # Score hand and add to list
winners = compare_hands(hand_scores) # Compare all scores and print result
# Iterate through winning hands and print each one
for player in winners:
    print(f"Player {player}:")
    for suit, ranks in hands[player].items():
        for rank in ranks:
            print_card((rank, suit))
# See if the user wants to play another game
print(separator)
play_again = str(print("Would you like to play again? (y/n)"))
if play_again.lower() == 'y':
    print("Great! Let's play again!")
else:
    # Print a goodbye message and quit
    print("Thanks for playing! Goodbye!")
    sys.exit()
print(separator)
# End of the main program
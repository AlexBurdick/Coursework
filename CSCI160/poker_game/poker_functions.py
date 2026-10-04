from random import randint

# Tuple for card ranks
ranks = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

# Dictionary for card suits
suits = {
    1: 'Hearts',   # Not starting at 0 because the suit is what gets returned in some 
    2: 'Diamonds', # of the hand rank fucntions, and 0 is returned when the hand doesn't 
    3: 'Clubs',    # match the pattern.
    4: 'Spades'
}

# Dictionary for card values
face_card_ranks = {
    1: 'Ace',
    11: 'Jack',
    12: 'Queen',
    13: 'King'
}

# Dictionary of hand rankings
hand_ranks = {
    8: "Straight Flush",
    7: "Four of a Kind",
    6: "Full House",
    5: "Flush",
    4: "Straight",
    3: "Three of a Kind",
    2: "Two Pair",
    1: "Pair",
    0: "High card"
}

# Sort the hand into the histogram
def rank_hand(hand):
    # Histogram to sort ranks
    rank_list = [0] * 13
    # Go through the hand and add each card to the histogram
    for suit, ranks in hand.items():
        for rank in ranks:
            rank_list[rank-1] += 1
    # Return the histogram
    return rank_list

# Functions for determining hand ranks:
def straight_flush(hand):
    suit = flush(hand)
    # If there is a flush
    if suit != 0:
        rank = straight(hand)
        # Check for a straight
        if rank != 0:
            # Return the rank and suit of the straight flush
            return [rank]
    # If there is no straight flush return 0
    return 0

def four_of_a_kind(hand):
    rank_list = rank_hand(hand)
    # Determine if one of the ranks has 4
    for i in range(len(rank_list)):
        if rank_list[i] == 4:
            rank = i+1
            return [rank]
    # If no card rank has 4, return 0
    return 0
        
def full_house(hand):
    # Check for three of a kind
    is_three_of_a_kind = three_of_a_kind(hand)
    if is_three_of_a_kind != 0:
        # Check for pair
        is_one_pair = one_pair(hand)
        if is_one_pair != 0:
            return [is_three_of_a_kind, is_one_pair]
    # If no card rank has 3 and another has 2, return 0
    return 0

def flush(hand):
    for suit, ranks in hand.items():
        if len(ranks) == 5:
            return highest_card(hand)
    # If no suit has 5, return 0
    return 0

def straight(hand):
    rank_list = rank_hand(hand)
    # Counter for cards-in-a-row
    is_straight = 0
    # See if there are 5 cards in a sequence
    for i in range(len(rank_list)):
        # If there is more than one of this card, a straight is impossible
        if rank_list[i] > 1:
            return 0
        # If rank_list[x] is 0, reset the cards-in-a-row counter
        if rank_list[i] == 0:
            is_straight = 0
            continue
        # If there is one of this rank, increment the cards-in-a-row counter
        if rank_list[i] == 1:
            is_straight += 1
            # If there have been 5 ranks in a row, return 4
            if is_straight == 5:
                rank = i+1
                return [rank]
    # If there are no consecutive cards, return 0
    return 0

def three_of_a_kind(hand):
    rank_list = rank_hand(hand)
    # Determine if one of the ranks has 3
    for i in range(len(rank_list)):
        if rank_list[i] == 3:
            rank = i+1
            return [rank]
    # If no card rank has 3, return 0
    return 0

def two_pair(hand):
    rank_list = rank_hand(hand)
    # List for pairs found, acts as a flag for finding first pair
    pair = []
    # Determine if one of the ranks has 2, reversed so the two numbers 
    # returned have the highest first (for comparison in case of tie)
    for i in reversed(range(len(rank_list))):
        if rank_list[i] == 2:
            pair.append(i+1) # Add the rank to the pair list
            # If there is already a pair, return 2
            if len(pair) == 2:
                return pair
    # If no two card ranks have 2, return 0
    return 0

def one_pair(hand):
    rank_list = rank_hand(hand)
    # Determine if one of the ranks has 2
    for i in range(len(rank_list)):
        if rank_list[i] == 2:
            # Return the rank of the pair
            rank = i+1
            return [rank]
    # If no card rank has 2, return 0
    return 0

# Determine the highest rank of card in the hand
def highest_card(hand):
    rank_list = rank_hand(hand)
    for i in reversed(range(len(rank_list))):
        if rank_list[i] != 0:
            # Return the value
            rank = i+1
            return [rank]

def score_hands(hand):
    # If there is a straight flush, store the highest card value
    if straight_flush(hand) != 0:
        hand_score = (8, straight_flush(hand))
    # If there is a four of a kind, store the rank of the four of a kind
    elif four_of_a_kind(hand) != 0:
        hand_score = (7, four_of_a_kind(hand))
    # If there is a full house, store the three of a kind value
    elif full_house(hand) != 0:
        hand_score = (6, full_house(hand))
    # If there is a flush, store the highest card value
    elif flush(hand) != 0:
        hand_score = (5, flush(hand))
    # If there is a straight, store the highest card value
    elif straight(hand) != 0:
        hand_score = (4, straight(hand))
    # If there is a three of a kind, store the rank of the three of a kind
    elif three_of_a_kind(hand) != 0:
        hand_score = (3, three_of_a_kind(hand))
    # If there is a two pair, store the higher pair value
    elif two_pair(hand) != 0:
        hand_score = (2, two_pair(hand))
    # If there is a pair, store the pair value
    elif one_pair(hand) != 0:
        hand_score = (1, one_pair(hand))
    # If there is no hand, store the highest card value
    else:
        hand_score = (0, highest_card(hand))
    # Send scored hands to the hand comparison function
    return hand_score

def compare_hands(hand_scores):
    scores, ranks = zip(*hand_scores)  # Unzip scores and ranks
    winners = []  # List to hold the winning players
    max_score = max(scores) # Get the maximum score from the scores list
    # Loop through the scores to find the players with the maximum score
    for i, score in enumerate(scores):
        if score == max_score:
            winners.append(i) # Add the index of the player to the winners list
    # If there are any ties in hand scores
    if len(winners) > 1:
        victors = [] # List to hold the players with the highest ranks
        # If there is a tie in the main scores, compare the ranks
        max_rank = max(ranks[player] for player in winners) # Get the maximum rank of the winners
        # Loop through the winners to find the players with the maximum rank
        for player in winners:
            if ranks[player] == max_rank:
                victors.append(player) # Add the player to the victors list
        winners = victors  # Update winners to only include those with the highest rank
    # Print the winner(s) of the game
    hand_string = format_hand_string(scores[winners[0]], ranks[winners[0]])
    print_winners(winners, hand_string)
    return winners

def print_winners(winners, hand_string):
    if len(winners) > 1:
        print('Players ' + ', '.join(map(str, winners)) + f' tie with {hand_string}.')
    else:
        print(f"Player {winners[0]} wins with {hand_string}.")

def format_hand_string(score, rank):
    hand_string = '' # String to hold the formatted hand description
    hand_rank = hand_ranks[score] # Get the name of the hand rank
    # Determine if rank is a list (for full house and two pair)
    #if isinstance(rank, list):
    #    card = [face_card_ranks[rank[0]] if rank[0] in face_card_ranks else str(rank[0]), face_card_ranks[rank[1]] if rank[1] in face_card_ranks else str(rank[1])]
    #else:
    #    card = (face_card_ranks[rank] if rank in face_card_ranks else str(rank))
    # If structure to create a formatted string based on the hand rank
    if score == 8:  # Straight Flush
        hand_string = f"a {rank[0]} high {hand_rank}"
    elif score == 7:  # Four of a Kind
        hand_string = f"Four {rank[0]}s"
    elif score == 6:  # Full House
        hand_string = f"a {hand_rank} {rank[0]}s over {rank[1]}s"
    elif score == 5:  # Flush
        hand_string = f"a {hand_rank}"
    elif score == 4:  # Straight
        hand_string = f"a {rank[0]} high Straight"
    elif score == 3:  # Three of a Kind
        hand_string = f"Three {rank[0]}s"
    elif score == 2:  # Two Pair
        hand_string = f"{hand_rank} {rank[0]}s and {rank[1]}s"
    elif score == 1:  # One Pair
        hand_string = f"a {hand_rank} of {rank[0]}s"
    elif score == 0:  # High Card
        hand_string = f"a {hand_rank} of {rank[0]}"
    return hand_string

# Create a list of cards from the possible rank/suit combinations
class deck (object): 
    def __init__(self, cards):
        # Nested loops to loop through the suits dictionary and ranks tuple
        cards = []
        for suit in suits:
            for rank in ranks:
                # Append a tuple of (rank, suit) to the deck list
                cards.append((rank, suit))
        self.shuffle

    # Randomize the order of the deck
    def shuffle(self):
        for x in range(1000):
            # Generate two random indices
            i1 = randint(0, len(self.cards)-1)
            i2 = randint(0, len(self.cards)-1)
            # Swap the cards at those indices
            temp = deck[i1]
            self.cards[i1] = deck[i2]
            self.cards[i2] = temp
    
    # Return the top card the deck only
    def deal(self):
        # Check if the deck is empty
        if len(self.cards) == 0:
            return None
        # Pop the first card from the deck and return it
        return self.cards.pop(0)

# Output an indiviual card
def print_card(card):
    rank, suit = card
    suit_str = suits[suit]
    # See if the card value is a face card
    if rank in face_card_ranks:
        rank_str = face_card_ranks.get(rank)
        print(f"{rank_str} of {suit_str}")
    else:
        print(f"{rank} of {suit_str}")

# Test code for printing all hands
def print_all_hands(hands):
    for i, hand in enumerate(hands):
        print(f"Player {i}'s hand:")
        for suit, ranks in hand.items():
            for rank in ranks:
                print_card((rank, suit))
    print()

# Deal 5 cards for any number of players
def deal_hands(num_players, deck):
    # Check to make sure there will be enough cards in a deck
    if num_players > 5:
        print("That is too many players for 5 card poker.")
    # Create a list with an element for each player with a dictionary
    # to act as the player's hand
    hands = [{ # The hand has a key for each suit
                1: [], # Hearts
                2: [], # Diamonds
                3: [], # Clubs
                4: []  # Spades
            } for i in range(num_players)]
    # Add one card to each player's hand 5 times
    for x in range(5):
        for y in range(len(hands)): # Loop through hands
            add_card(hands[y], deck) # adding one card
    return hands

# Change cards in the player's hand based on user input
def change_cards(exchange_indices, hand, deck):
    counter = 0
    for ranks in hand.values():
        if ranks: 
            for rank in ranks[:]:
                counter += 1
                if counter in exchange_indices:
                    # Remove the card at the specified index
                    ranks.remove(rank)
    # Add new cards to the hand for each one removed
    for i in range(len(exchange_indices)):
        add_card(hand, deck)

# Add a card to the player's hand
def add_card(hand, deck):
    rank, suit = deal(deck) # Get the attributes of the card
    hand[suit].append(rank) # Add the card to the appropriate suit in the hand

def computer_change_cards(hands, deck):
    # This logic will have computer players exchange cards if they have three of a kind, 
    # two pair, one pair, or high card.
    # Loop through hands except the first one (human player)
    for hand in hands[1:]:
        score = score_hands(hand) # Score the hand
        # If the hand is Three of a Kind, exchange 2
        if score[0] == 3:
            for i in range(remove_cards(hand, score[1])):
                add_card(hand, deck)
        # If the hand is Two Pair, exchange 1 card
        elif score[0] == 2:
            for i in range(remove_cards(hand, score[1])):
                add_card(hand, deck)
        # If the hand is One Pair, exchange 3 cards
        elif score[0] == 1:
            for i in range(remove_cards(hand, score[1])):
                add_card(hand, deck)
        # If the hand is a high card, exchange 4 cards
        elif score[0] == 0:
            traded = 0
            for suit, ranks in hand.items():
                if len(ranks) == 4:
                    keep_suit = suit # Keep the suit with 4 cards
                    traded = 1
                    # If there are 4 cards in a suit, exchange the card in the other suit
                    for s, r in hand.items():
                        if s != keep_suit:
                            r.clear()
                    add_card(hand, deck)
            if traded == 1:
                continue
            for i in range(remove_cards(hand, score[1])):
                add_card(hand, deck)

def remove_cards(hand, cards):
    cards_removed = 0 # Holds the number of cards that get removed
    for ranks in hand.values(): # Loop through the values in the hand (no need for suits)
        for rank in ranks[:]: # Go through a copy of all the ranks
            for card in cards: # Cards is the ranks returned by hands_scoring (cards not to exchange)
                keep_flag = 0 # Flag to tell if the card in the hand is one to keep
                if rank == card: # If this card matches one to keep
                    keep_flag = 1 # change flag to indicate keep
            if keep_flag == 0:
                ranks.remove(rank)
                cards_removed += 1
    return cards_removed

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
//import java.lang.Math;

public class blackjack
{
	public static int placeBet()
	{
		Scanner userIn = new Scanner(System.in);
		int bet = 0;
		while (bet <= 0)
		{
			System.out.print("How much would you like to bet?\n: ");
			try
			{
				bet = userIn.nextInt();
			}
			catch (InputMismatchException ime)
			{
				userIn.next();
				System.out.println("please give a whole number ie: 250\n");
			}
		}
		return (bet);
	}

	public static int placeInsurance(int bet)
	{
		Scanner userIn = new Scanner(System.in);
		int insurance = 0;

		System.out.println("\nInsurrance is open.");
		while (true)
		{
			try
			{
				System.out.print("How much would you like to insure?\n: ");
				insurance = userIn.nextInt();
				break ;
			}
			catch (InputMismatchException ime)
			{
				userIn.next();
				System.out.println("Please enter a whole number. If you would not like to insure enter 0\n");
			}
		}
		if (insurance > bet / 2)
		{
			System.out.println("Max insurance is 1/2 of your original bet");
			insurance = bet / 2;
		}
		return (insurance);
	}

	public static int beginGame()
	{
		Deck deck = new Deck();
		ArrayList<ArrayList<String>> playerHands = new ArrayList<ArrayList<String>>();
		playerHands.add(new ArrayList<String>());
		// ArrayList<String> playerDeck = new ArrayList<String>();
		ArrayList<String> dealerDeck = new ArrayList<String>();
		Scanner userIn = new Scanner(System.in);
		int bet = 0;
		int insurance = 0;
		int winnings = 0;

		System.out.println("beginning game");
		//place bet;
		bet = placeBet();
		System.out.println("You have placed an initial bet of $" + bet);
		//give the player two cards and draw cards for the dealer
		dealCards.deal_start_cards(deck ,playerHands.get(0), dealerDeck);
		System.out.println("after stard hadn" + deck.getTotalCards()); // remove this
		System.out.println("Your hand:\n" + playerHands.get(0));
		System.out.println("Dealers face up card\n" + dealerDeck.get(1));
		if (dealerDeck.get(1).indexOf("Ace") != -1)
		{
			insurance = placeInsurance(bet);
		}
		System.out.println("dealer score: " + score.get_score(dealerDeck));
		System.out.println("player score: " + score.get_score(playerHands.get(0)));
		if (score.get_score(dealerDeck) == -1)
		{
			if (score.get_score(playerHands.get(0)) != -1)
				winnings += ((bet * -1) + (insurance * 2));
			// othersie we have a "Push" which is all bets given back to player
			else
				winnings += insurance * 2;
			return (winnings);
		}
		winnings += playGame.play_game(deck, playerHands, dealerDeck, bet, insurance);
		return (winnings);
	}

	public static void displayRules()
	{
		System.out.println("1. This game is played with 1 deck of 52 cards.\n");
		System.out.println("2. Aces may be counted as 1 or 11 points, 2 to 9 according to pip value,\nand tens and face cards count as ten points.\n");
		System.out.println("3. The value of a hand is the sum of the point values of the individual cards.\nExcept, a \"blackjack\" is the highest hand, consisting of an ace and any 10-point card, and it outranks all other 21-point hands.\n");
		System.out.println("4. After the players have bet, the dealer will give two cards to each player and two cards to himself. One of the dealer cards is dealt face up. The facedown card is called the \"hole card.\"\n");
		System.out.println("5. If the dealer has an ace showing, he will offer a side bet called \"insurance.\"\nThis side wager pays 2 to 1 if the dealer's hole card is any 10-point card.\nInsurance wagers are optional and may not exceed half the original wager.\n");
		System.out.println("6. If the dealer has a ten or an ace showing (after offering insurance with an ace showing),\nthen he will peek at his facedown card to see if he has a blackjack.\nIf he does, then he will turn it over immediately.\n");
		System.out.println("7. If the dealer does have a blackjack, then all wagers (except insurance) will lose,\nunless the player also has a blackjack, which will result in a push.\nThe dealer will resolve insurance wagers at this time.\n");
		System.out.println("8. Play begins with the player to the dealer's left.\nThe following are the choices available to the player:");
		System.out.println("	- Stand: Player stands pat with his cards.");
		System.out.println("	- Hit: Player draws another card (and more if he wishes).\n\tIf this card causes the player's total points to exceed 21 (known as \"breaking\" or \"busting\") then he loses.");
		System.out.println("	- Double: Player doubles his bet and gets one, and only one, more card.");
		System.out.println("	- Split: If the player has a pair, or any two 10-point cards,\n\tthen he may double his bet and separate his cards into two individual hands.\n\tThe dealer will automatically give each card a second card. Then, the player may hit, stand, or double normally.\n\tHowever, when splitting aces, each ace gets only one card. Sometimes doubling after splitting is not allowed.\n\tIf the player gets a ten and ace after splitting, then it counts as 21 points, not a blackjack.\n\tUsually the player may keep re-splitting up to a total of four hands.\n\tSometimes re-splitting aces is not allowed.");
		System.out.println("	- Surrender: The player forfeits half his wager,\n\tkeeping the other half, and does not play out his hand. This option is only available on the initial two cards.\n");
		System.out.println("9. After each player has had his turn, the dealer will turn over his hole card.\nIf the dealer has 16 or less, then he will draw another card.\nA special situation is when the dealer has an ace and any number of cards totaling six points (known as a \"soft 17\").\nThe dealer will also hit a soft 17.\n");
		System.out.println("10. If the dealer goes over 21 points, then any player who didn't already bust will win.\n");
		System.out.println("11. If the dealer does not bust, then the higher point total between the player and dealer will win.\n");
		System.out.println("12. Winning wagers pay even money, except a winning player blackjack usually pays 3 to 2.\n");
	}

	public static void main(String[] args)
	{
		int totalGames = 0;
		int gamesWon = 0;
		int totalWinnings = 0;
		int gameWinnings = 0;
		boolean playing = true;
		Scanner userIn = new Scanner(System.in);
		String usr;

		System.out.println("Welcome to BlackJack.");
		System.out.println("\ntype /rules to see rules for black jack");
		while (playing)
		{
			System.out.println("Ready to begin a game? y/n:");
			usr = userIn.nextLine();
			if (usr.toLowerCase().equals("y") || usr.toLowerCase().equals("yes"))
			{
				gameWinnings = beginGame();
				if (gameWinnings > 0)
					gamesWon++;
				totalWinnings += gameWinnings;
				totalGames++;
				System.out.println("Total Winnings $" + totalWinnings + "so far");
			}
			else if (usr.toLowerCase().equals("n") || usr.toLowerCase().equals("no"))
				playing = false;
			else if(usr.toLowerCase().equals("/rules"))
				displayRules();
			else
				System.out.println("I dont understand.");
		}
		System.out.println("goodbye!");
	}
}

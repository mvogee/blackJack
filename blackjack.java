import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class blackjack // dont know if this is needed
{


	public static void deal_start_cards(Deck deck,
					ArrayList<String> playerDeck, ArrayList<String> dealerDeck)
	{
		int i;
		int cardidx;
		for (i = 0; i < 2; i++)
		{
			cardidx = (int)(Math.random() * deck.getTotalCards());
			playerDeck.add(deck.getCard(cardidx));
			deck.removeCard(cardidx);
			deck.setTotalCards(deck.getTotalCards() - 1);
		}
		System.out.println(playerDeck);
		for (i = 0; i < 2; i++)
		{
			cardidx = (int)(Math.random() * deck.getTotalCards());
			dealerDeck.add(deck.getCard(cardidx));
			deck.removeCard(cardidx);
			deck.setTotalCards(deck.getTotalCards() - 1);
		}
		System.out.println(dealerDeck);
	}

	public static int beginGame()
	{
		Deck deck = new Deck();
		ArrayList<String> playerDeck = new ArrayList<String>();
		ArrayList<String> dealerDeck = new ArrayList<String>();
		Scanner userIn = new Scanner(System.in);
		int bet = 0;
		int insurance = 0;

		System.out.println("beginning game");
		//place bet;
		System.out.print("How much would you like to bet?\n: ");
		bet = userIn.nextInt();
		System.out.println("You have placed an initial bet of $" + bet);
		//give the player two cards and draw cards for the dealer
		deal_start_cards(deck ,playerDeck, dealerDeck);
		System.out.println("Your hand:\n" + playerDeck);
		System.out.println("Dealers face up card\n" + dealerDeck.get(1));
		if (dealerDeck.get(1).indexOf("Ace") != -1)
		{
			System.out.println("Insurrance is open. How much would you like to insure?\n Enter ammount: ");
			insurance = userIn.nextInt();
			if (insurance > bet / 2)
			{
				System.out.println("max insurance is 1/2 of your original bet");
				insurance = bet / 2;
			}
		}
		if (get_dealer_score() == -1);// make this. checks for dealer score. -1 is a blackjack
		{
			if (get_player_score() != -1) // make this. checks for players score. -1 is a blackjack
				return ((bet * -1) + (insurance * 2));
			// othersie we have a "Push" need to find out what this is.
		}
		play_game(); // at this point all the beginning setup is done and we can let the player play
		return (1);
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
		System.out.println("	- Split: If the player has a pair, or any two 10-point cards,\n\tthen he may doublehis bet and separate his cards into two individual hands.\n\tThe dealer will automatically give each card a second card. Then, the player may hit, stand, or double normally.\n\tHowever, when splitting aces, each ace gets only one card. Sometimes doubling after splitting is not allowed.\n\tIf the player gets a ten and ace after splitting, then it counts as 21 points, not a blackjack.\n\tUsually the player may keep re-splitting up to a total of four hands.\n\tSometimes re-splitting aces is not allowed.");
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
				gamesWon += beginGame();
				totalGames++;
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

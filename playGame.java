import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class playGame
{
	public static boolean checkValidSplit(ArrayList<String> playerHand)
	{
		String firstCard = playerHand.get(0).split(" ")[0];
		String secondCard = playerHand.get(1).split(" ")[0];
		if (firstCard == secondCard)
			return (true);
		else
			return (false);
	}

	public static void splitHand(Deck deck, ArrayList<ArrayList<String>> playerHands)
	{
		int hand = 1;
		Scanner userIn = new Scanner(System.in);

		System.out.println(playerHands.size());
		if (playerHands.size() > 1 && playerHands.size() <= 4)
		{
			while (true)
			{
				try
				{
					System.out.println("which hand would you like to split?");
					hand = userIn.nextInt();
					if (hand > playerHands.size())
						System.out.println("enter a hand 1 - " + playerHands.size());
					else
						break ;
				}
				catch (InputMismatchException ime)
				{
					System.out.println("enter a hand 1 - " + playerHands.size());
					hand = userIn.nextInt();
				}
			}
		}
		else if (playerHands.size() == 4)
		{
			System.out.println("You can not have more than 4 hands.");
			return ;
		}
		if (!checkValidSplit(playerHands.get(hand - 1)))
		{
			System.out.println("That is not a valid hand to split");
			return ;
		}

	}

	public static int play_game(Deck deck, ArrayList<ArrayList<String>> playerHands,
					ArrayList<String> dealerDeck, int bet, int insurance)
	{
		String	usr;
		Scanner	userIn = new Scanner(System.in);
		boolean	playing = true;
		boolean	surrender = false;
		int		winnings = 0;

		System.out.println("It is your turn.");
		while (playing)
		{
			System.out.println("Plays:\nStand\nHit\nDouble\nSplit\nSurrender\n");
			usr = userIn.nextLine();
			if (usr.toLowerCase().equals("stand"))
				playing = false;
			else if (usr.toLowerCase().equals("hit"))
				dealCards.deal_singel_card(deck, playerHands.get(0));
			else if (usr.toLowerCase().equals("double"))
			{
				dealCards.deal_singel_card(deck, playerHands.get(0));
				bet *= 2;
				playing = false;
			}
			else if (usr.toLowerCase().equals("split"))
				splitHand(deck, playerHands);
			else if (usr.toLowerCase().equals("surrender"))
			{
				winnings = bet / 2 * -1;
				playing = false;
				surrender = true;
			}
			else
				System.out.println("I dont understand that play");
			System.out.println("total cards in deck " + deck.getTotalCards());
		}
		// play out the dealers turn
		// check who wins
		 return (winnings);
	}
}

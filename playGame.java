import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class playGame
{
	public static boolean checkValidSplit(ArrayList<String> playerHand)
	{
		String firstCard = playerHand.get(0).split(" ")[0];
		String secondCard = playerHand.get(1).split(" ")[0];
		if (firstCard.equals(secondCard))
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
		else
		{
			playerHands.add(new ArrayList<String>());
			playerHands.get(playerHands.size() - 1).add(playerHands.get(hand - 1).get(1));
			playerHands.get(hand - 1).remove(1);
			dealCards.deal_singel_card(deck, playerHands.get(hand - 1));
			dealCards.deal_singel_card(deck, playerHands.get(playerHands.size() - 1));
		}
	}

	public static int play_game(Deck deck, ArrayList<ArrayList<String>> playerHands,
					ArrayList<String> dealerDeck, int bet, int insurance)
	{
		String	usr;
		Scanner	userIn = new Scanner(System.in);
		//boolean	playing = true;
		boolean	surrender = false;
		int		winnings = 0;
		boolean splitable = true;
		// finalHands holds the no longer playing hands (stood hands).
		ArrayList<ArrayList<String>> finalHands = new ArrayList<ArrayList<String>>();
		int i = 0;
		// I need to find a way to play turns for each hand and stop playing turns for hands that stand.
		System.out.println("It is your turn.");
		while (playerHands.size() > 0)
		{
			for (int k = 0; k < playerHands.size(); k++)
			{
				System.out.println("hand " + (k + 1) + ": " + playerHands.get(k));
			}
			if (i >= playerHands.size())
				i = 0;
			System.out.println("\nplaying hand: " + (i + 1) + " " + playerHands.get(i));
			System.out.println("current hand total: " + score.get_score(playerHands.get(i)));
			System.out.println("Plays:\nStand\nHit\nDouble\nSplit\nSurrender\n");
			usr = userIn.nextLine();
			if (usr.toLowerCase().equals("stand"))
			{
				finalHands.add(playerHands.get(i));
				playerHands.remove(i);
			}
			else if (usr.toLowerCase().equals("hit"))
			{
				dealCards.deal_singel_card(deck, playerHands.get(i));
				System.out.println("card dealt: " + playerHands.get(i).get(playerHands.get(i).size() - 1));
				splitable = false;
			}
			else if (usr.toLowerCase().equals("double"))
			{
				dealCards.deal_singel_card(deck, playerHands.get(i));
				System.out.println("card dealt: " + playerHands.get(i).get(playerHands.get(i).size() - 1));
				bet *= 2;
				finalHands.add(playerHands.get(i));
				playerHands.remove(i);
				splitable = false;
			}
			else if (usr.toLowerCase().equals("split"))
			{
				if (splitable == true)
					splitHand(deck, playerHands);
				else
					System.out.println("you cannot split your hands after you have hit.");
			}
			else if (usr.toLowerCase().equals("surrender"))
			{
				winnings = bet / 2 * -1;
				playerHands.remove(i);
				surrender = true;
			}
			else
				System.out.println("I dont understand that play");
			if (playerHands.size() > i && score.get_score(playerHands.get(i)) > 21)
			{
				System.out.println("Busted!");
				playerHands.remove(i);
			}
			i++;
		}
		// play out the dealers turn
		// check who wins
		 return (winnings);
	}
}

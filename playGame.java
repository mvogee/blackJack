import java.util.ArrayList;
import java.util.Scanner;

public class playGame
{
	public static int play_game(Deck deck, ArrayList<String> playerDeck,
					ArrayList<String> dealerDeck, int bet, int insurance)
	{
		String usr;
		Scanner userIn = new Scanner(System.in);
		boolean playig = true;

		System.out.println("It is your turn.");
		while (playing)
		{
			System.out.println("Options:\nStand\nHit\nDouble\nSplit\nSurrender\n");
			usr = userIn.nextLine();
			if (usr.toLowerCase().equals("stand"))
				playing = false;
			else if (usr.toLowerCase().equals("hit"))
				dealCards.hit(deck, playerDeck);
			else if (usr.toLowerCase().equals("double"))
				player_double(); // create this. after a double the player is done
			else if (usr.toLowerCase().equals("split"))
				split(); // create this
			else if (usr.toLowerCase().equals("surrender"))
				surrneder(); // creat this
			else
				System.out.println("I dont understand that play");
		}
		// play out the dealers turn
		// check who wins
		// return winnings
	}
}

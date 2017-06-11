import java.util.Scanner;

public class blackjack // dont know if this is needed
{
	public static void main(String[] args)
	{
		boolean begin = false;
		Scanner userIn = new Scanner(System.in);
		String usr;

		System.out.println("Welcome to BlackJack.");
		while (!begin)
		{
			System.out.println("ready to begin the game? y/n: ");
			usr = userIn.nextLine();

			System.out.println(usr);
			if (usr.toLowerCase().equals("y") || usr.toLowerCase().equals("yes"))
			{
				System.out.println("beginning game");
				begin = true;
			}
			else if (usr.toLowerCase().equals("n") || usr.toLowerCase().equals("no"))
			{
				System.out.println("quit");
				break ;
			}
			else
			{
				System.out.println("I dont understand.");
			}
		}
		if (begin == true)
			System.out.println("starting");//begin_game(); // make me
		else
			System.out.println("goodbye!");


		Deck deck = new Deck();
		deck.printDeck();
		//System.out.println(deck.getTotalCards());
	}
}

import java.util.Scanner;

public class blackjack // dont know if this is needed
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.printDeck();
		System.out.println(deck.getTotalCards());
	}
}

import java.util.Scanner;

public static ArrayList<String> create_deck()
{
	ArrayList<String> deck = new ArrayList<string>();
	String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
	String cards[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
						"Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	//String fullCard = NULL;
	for (int suit = 0; suit < 4; suit++)
	{
		for (int card = 0; card < 13; car++)
		{
			//fullCard = suits[suit] + cards[card]; try whats below first
			deck.add(suits[suit] + cards[card]);
		}
	}
	return (deck);
}

public class Deck
{
	private ArrayList<String> deck = create_deck();
	private int totalCards = deck.size(); // should come out to 52

	public static int getTotalCards()
	{
		return (totalCards);
	}
	public static void setTotalCards(int totalCards)
	{
		this.totalCards = totalCards;
	}
	public static String getCard(int index)
	{
		return (deck.get(index));
	}
	public static void removeCard(int index)
	{
		deck.remove(index);
	}
}
public class blackjackMain // dont know if this is needed
{
	public static void main(String[] args)
	{
		deck = new Deck;
	}
}

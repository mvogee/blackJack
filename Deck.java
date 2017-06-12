import java.util.ArrayList;

public class Deck
{
	private static ArrayList<String> create_deck()
	{
		ArrayList<String> deck = new ArrayList<String>();
		String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String cards[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
							"Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		for (int suit = 0; suit < 4; suit++)
		{
			for (int card = 0; card < 13; card++)
			{
				deck.add(cards[card] + " of " + suits[suit]);
			}
		}
		return (deck);
	}

	private ArrayList<String> deck = create_deck();
	private int totalCards = deck.size();

	public int getTotalCards()
	{
		return (totalCards);
	}
	public void setTotalCards(int totalCards)
	{
		totalCards = totalCards;
	}
	public String getCard(int index)
	{
		return (deck.get(index));
	}
	public void removeCard(int index)
	{
		deck.remove(index);
	}
	public void printDeck()
	{
		System.out.println(deck);
	}

}

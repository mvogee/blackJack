import java.lang.Math;
import java.util.ArrayList;

public class dealCards
{
	// deal the begining game cards 2 to the player and 2 to the dealer
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

	// deal one card to the given playerDeck and remove the card from the deck
	public static void deal_singel_card(Deck deck, ArrayList<String> playerDeck)
	{
		int cardidx;
		cardidx = (int)(Math.random() * deck.getTotalCards());
		playerDeck.add(deck.getCard(cardidx));
		deck.removeCard(cardidx);
		deck.setTotalCards(deck.getTotalCards() - 1);
	}
	// used for testing splitting.
	// public static void cheats_deal_splitable(Deck deck, ArrayList<String> playerDeck)
	// {
	// 	playerDeck.add(deck.getCard(7));
	// 	playerDeck.add(deck.getCard(20));
	// 	deck.removeCard(7);
	// 	deck.removeCard(20);
	// 	deck.setTotalCards(deck.getTotalCards() - 2);
	// }
}

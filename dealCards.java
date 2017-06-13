public class dealCards
{ // deal_start_cards might need to not be static
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
}

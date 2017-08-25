import java.util.ArrayList;

public class playDealer {

	public static void playDealer(Deck deck, ArrayList<String> dealerDeck) {
		while (score.get_score(dealerDeck) < 17)
		{
			dealCards.deal_singel_card(deck, dealerDeck);
		}
		if (score.get_score(dealerDeck) == 17 && isSoftSevenTeen(dealerDeck) == true)
		{
			dealCards.deal_singel_card(deck, dealerDeck);
		}
	}
	private static boolean isSoftSevenTeen(ArrayList<String> dealerDeck)
	{
		for (int i = 0; i < dealerDeck.size(); i++)
		{
			if (score.cardValue(dealerDeck.get(i)) == 1)
				return (true);
		}
		return (false);
	}
}

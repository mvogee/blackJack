import java.util.ArrayList;

public class score
{
	public static int cardValue(String card)
	{
		if (card.indexOf("Ace") != -1)
			return (1);
		else if (card.indexOf("Two") != -1)
			return (2);
		else if (card.indexOf("Three") != -1)
			return (3);
		else if (card.indexOf("Four") != -1)
			return (4);
		else if (card.indexOf("Five") != -1)
			return (5);
		else if (card.indexOf("Six") != -1)
			return (6);
		else if (card.indexOf("Seven") != -1)
			return (7);
		else if (card.indexOf("Eight") != -1)
			return (8);
		else if (card.indexOf("Nine") != -1)
			return (9);
		else
			return (10);
	}

	public static int checkBlackjack(ArrayList<String> deck)
	{
		if (cardValue(deck.get(0)) == 1 && cardValue(deck.get(1)) == 10 ||
		cardValue(deck.get(1)) == 1 && cardValue(deck.get(0)) == 10)
			return (1);
		else
			return (0);
	}

	public static int get_score(ArrayList<String> deck)
	{
		int score = 0;
		int aces = 0;
		int card = 0;

		if (deck.size() == 2 && checkBlackjack(deck) == 1) // blackjack
			return (-1);
		for (int i = 0; i < deck.size(); i++)
		{
			card = cardValue(deck.get(i));
			if (card == 1)
				aces++;
			else
				score += card;
		}
		while (aces > 0)
		{
			if (aces == 1 && score <= 10)
				score += 11;
			else
				score += 1;
			aces--;
		}
		return (score);
	}
}

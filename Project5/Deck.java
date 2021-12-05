import java.util.Random;
public class Deck 
{
    private final int DeckSize = 52;
    private final int Shuffles = 1000;
    private final int HandSize = 5;
    public int restOfDeck = 6;
    Card[] deck = new Card[DeckSize];
    Random r = new Random();
    public void fillDeck()
    {
        int i = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                deck[i] = new Card();
                deck[i].suit = suit;
                deck[i].rank = rank;
                i++;
            }
        }
    }
    public void shuffle()
    {
        for (int i = 0; i <= Shuffles; i++)
        {
            int n1 = r.nextInt(DeckSize);
            int n2 = r.nextInt(DeckSize);
            Card temp = deck[n1];
            deck[n1] = deck[n2];
            deck[n2] = temp;
        }
        }   
    public Card[] deal()
    {
        Card[] hand = new Card[HandSize];
        for (int i = 0; i < 5; i++)
        {
            hand[i] = deck[i];
        }
        return hand;
    }
    public Card redeal()
    {
        Card nextCard = deck[restOfDeck];
        restOfDeck++;
        return nextCard;
    }
    public void refreshDeckPosition()
    {
        restOfDeck = 6;
    }
}
public class Player 
{
    public Card[] draw(Deck deck)
    {
        Card[] hand = deck.deal();
        return hand;
    }
}
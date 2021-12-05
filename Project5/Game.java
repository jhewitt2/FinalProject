import java.util.Arrays;
import java.util.Scanner;

public class Game 
{
    Scanner scan = new Scanner(System.in);
    Deck deck = new Deck();
    Player player = new Player();
    private final int HandSize = 5;
    private int again = 1;
    Card[] hand;

    public void play()
    {
        while (again == 1)
        {
            deck.fillDeck();
            deck.shuffle();
            hand = player.draw(deck);  
            Arrays.sort(hand);
            this.checkHand();      
            Arrays.sort(hand);
            this.run();
            this.again();
        }
        System.out.println("End of Game");
    }
    public void makeHand()
    {
        hand[0].rank = 1;
        hand[1].rank = 2;
        hand[2].rank = 3;
        hand[3].rank = 4;
        hand[4].rank = 5;
        hand[0].suit = 1;
        hand[1].suit = 1;
        hand[2].suit = 1;
        hand[3].suit = 1;
        hand[4].suit = 1;
    }
    public void checkHand()
    {
        for (int i = 0; i < HandSize; i++)
        {
            this.face(hand[i]);
        }
    }
    public int royalFlush()
    {
        if (hand[0].rank == 1 && hand[1].rank == 10 && hand[2].rank == 11 &&
                hand[3].rank == 12 && hand[4].rank == 13)
        {
            return 1;
        }else{
            return 0;
        }
    }
    public int straightFlush()
    {
            for (int i = 1; i < 5; i++)
            {
            if (hand[0].suit != hand[i].suit)
            {
                return 0;
            }
        }
        for (int ii = 1; ii < 5; ii++)
        {
            if (hand[ii - 1].rank != (hand[ii].rank - 1))
            {
                return 0;
            }    
        }
        return 1;
    }
    public int fourOfaKind()
    {
        if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank)
        {
            return 0;
        }else{
            return 1;
        }
    }
    public int fullHouse()
    {
        int a = 0;
        for (int i = 1; i < 5; i++)
        {
            if (hand[i - 1].rank == hand[i].rank)
            {
                a++;
            }
        }
        if (a == 3)
        {
            return 1;
        }else{
            return 0;
        }
    }
    public int flush()
    {
        for (int i = 1; i < 5; i++)
        {
            if (hand[0].suit != hand[i].suit)
            {
                return 0;
            }
        }
        return 1;
    }
    public int straight()
    {
        for (int i = 1; i < 5; i++)
        {
            if (hand[i - 1].rank != (hand[i].rank - 1))
            {
                return 0;
            }
        }
        return 1;
    }
    public int triple()
    {
        if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank)
        {
            return 1;
        }
        return 0;
    }
    public int twoPairs()
    {
        int a = 0;
        for(int i = 1; i < 5; i++)
        {
            if (hand[i - 1].rank == hand[i].rank)
            {
                a++;
            }
        }
        if (a == 2)
        {
            return 1;
        }else{
            return 0;
        }
    }
    public int pair()
    {
        int a = 0;
        for(int i = 1; i < 5; i++)
        {
            if (hand[i - 1].rank == hand[i].rank)
            {
                a++;
            }
        }
        if (a == 1)
        {
            return 1;
        }else{
            return 0;
        }
    }
    public int highCard()
    {
        int highCard = 0;
        for (int i = 0; i < 5; i++)
        {
            if (hand[i].rank > highCard)
            {
                highCard = hand[i].rank;
            }
        }
        return highCard;
    }
    public void run()
    {
        if (this.royalFlush() == 1)
        {
            System.out.println("Royal flush!");
        }
        else if (this.straightFlush() == 1)
        {
            System.out.println("Straight flush!");
        }
        else if (this.fourOfaKind() == 1)
        {
            System.out.println("Four of a kind!");
        }
        else if (this.fullHouse() == 1)
        {
            System.out.println("Full house!");
        }
        else if (this.flush() == 1)
        {
            System.out.println("Flush!");
        }
        else if (this.straight() == 1)
        {
            System.out.println("Straight!");
        }
        else if (this.triple() == 1)
        {
            System.out.println("Three of a kind!");
        }
        else if (this.twoPairs() == 1)
        {
            System.out.println("Two pairs!");
        }
        else if (this.pair() == 1)
        {
            System.out.println("One pair!");
        }else{
            int highCard = this.highCard();
            System.out.println("High card is " + highCard);
        }
    }
    public void face(Card card)
    {
        if (card.rank == 1)
        {
            System.out.print("Ace of ");
        }
        if (card.rank == 2)
        {
            System.out.print("Two of ");
        }
        if (card.rank == 3)
        {
            System.out.print("Three of ");
        }
        if (card.rank == 4)
        {
            System.out.print("Four of ");
        }
        if (card.rank == 5)
        {
            System.out.print("Five of ");
        }
        if (card.rank == 6)
        {
            System.out.print("Six of ");
        }
        if (card.rank == 7)
        {
            System.out.print("Seven of ");
        }
        if (card.rank == 8)
        {
            System.out.print("Eight of ");
        }
        if (card.rank == 9)
        {
            System.out.print("Nine of ");
        }
        if (card.rank == 10)
        {
            System.out.print("Ten of ");
        }
        if (card.rank == 11)
        {
            System.out.print("Jack of ");
        }
        if (card.rank == 12)
        {
            System.out.print("Queen of ");
        }
        if (card.rank == 13)
        {
            System.out.print("King of ");
        }
        if (card.suit == 1)
        {
            System.out.print("Spades");
            System.out.println();
        }
        if (card.suit == 2)
        {
            System.out.print("Hearts");
            System.out.println();
        }
        if (card.suit == 3)
        {
            System.out.print("Diamonds");
            System.out.println();
        }
        if (card.suit == 4)
        {
            System.out.print("Clubs");
            System.out.println();
        }
    }
    public void again()
    {
        System.out.print("Play again? (1 = yes, 0 = no)");
        again = scan.nextInt();
    }
}
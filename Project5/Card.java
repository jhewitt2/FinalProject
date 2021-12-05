
public class Card implements Comparable<Card>
{
    int rank;
    int suit;
    public int compareTo(Card i)
    {
        if (this.rank == (i.rank)){
            return 0;
	}
	else if ((this.rank) > (i.rank)){
	    return 1;
	}else{
	    return -1;
	}
    }
}


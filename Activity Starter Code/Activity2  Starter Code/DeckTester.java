/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] rank1 = {"Jack", "Queen", "King"};
		String[] suit1 = {"Hearts", "Spades", "Diamonds"};
		int[] value1 = {11, 12, 13};
	    Deck deck1 = new Deck(rank1, suit1, value1);
	    System.out.println("Deck1 size should be 3: " + deck1.size());
	    
	    String[] rank2 = {"10", "Queen", "King"};
	    String[] suit2 = {"Clubs", "Spades", "Diamonds"};
	    int[] value2 = {10, 12, 13};
	    Deck deck2 = new Deck(rank2, suit2, value2);
	    System.out.println("Deck2 should not be empty: " + !deck2.isEmpty());
	    
	    String[] rank3 = {"1", "3", "Queen"};
	    String[] suit3 = {"Diamonds", "Spades", "Hearts"};
	    int[] value3 = {1, 3, 12};
	    Deck deck3 = new Deck(rank3, suit3, value3);
	    System.out.println("Deck3 dealt card is: " + deck3.deal());
	   
	}
}

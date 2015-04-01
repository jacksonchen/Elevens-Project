/**
 * This is a class that tests the Deck class using assert statements.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency
	 * using assert statements.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		test1CardDeck();
		test2CardDeck();
		testShuffle();
		System.out.println("All tests passed!");
	}


	/**
	 * Create a 1-card Deck and test the Deck methods with it.
	 */
	private static void test1CardDeck() {
		String[] r1 = {"ace"};
		String[] s1 = {"spades"};
		int[] v1 = {1};
		Deck d = new Deck(r1, s1, v1);
		testOneCard(d, new Card("ace", "spades", 1));
		testEmpty(d);

		d.shuffle();
		testOneCard(d, new Card("ace", "spades", 1));
		testEmpty(d);
	}

	/**
	 * Create a 2-card Deck and test the Deck methods with it.
	 */
	private static void test2CardDeck() {
		String[] r2 = {"ace", "2"};
		String[] s2 = {"hearts"};
		int[] v2 = {1, 2};
		Deck d = new Deck(r2, s2, v2);
		assert d.size() == 2 : "Initial size is " + d.size()
			+ ". It should be 2.";
		assert !d.isEmpty() : "Initial deck is empty.";
		boolean aceIsFirst, twoIsFirst;
		Card c = d.deal();
		assert c != null : "1st card dealt is null.";
		aceIsFirst = c.matches(new Card("ace", "hearts", 1));
		twoIsFirst = c.matches(new Card("2", "hearts", 2));
		assert (aceIsFirst || twoIsFirst) : "1st card dealt is " + c
			+ ".  It is not the one of the two correct cards.";
		assert d.size() == 1 : "Size after one deal is " + d.size()
			+ ". It should be 1.";
		assert !d.isEmpty() : "Deck is empty after one deal.";
		c = d.deal();
		assert c != null : "2nd card dealt is null.";
		if (aceIsFirst) {
			assert c.matches(new Card("2", "hearts", 2))	: "2nd card dealt is "
				+ c + ". It is not one of the two correct cards.";
		} else {
			assert c.matches(new Card("ace", "hearts", 1)) : "2nd card dealt is "
				+ c + ". It is not one of the two correct cards.";
		}
		testEmpty(d);

		d.shuffle();
		c = d.deal();
		assert c != null : "1st card dealt after shuffle is null.";
		aceIsFirst = c.matches(new Card("ace", "hearts", 1));
		twoIsFirst = c.matches(new Card("2", "hearts", 2));
		assert (aceIsFirst || twoIsFirst) : "1st card dealt after shuffle is "
			+ c + ".  It is not the one of the two correct cards.";
		assert d.size() == 1 : "Size is " + d.size()
			+ "after shuffle and one deal. It should be 1.";
		assert !d.isEmpty() : "Deck is empty after shuffle and one deal.";
		c = d.deal();
		assert c != null : "2nd card dealt after shuffle is null.";
		if (aceIsFirst) {
			assert c.matches(new Card("2", "hearts", 2))
				: "2nd card dealt after shuffle is " + c
				+ ". It is not the one of the two correct cards.";
		} else {
			assert c.matches(new Card("ace", "hearts", 1))
				: "2nd card dealt after shuffle is " + c
				+ ". It is not the one of the two correct cards.";
		}
		testEmpty(d);
	}

	/**
	 * Check that the given deck is empty.
	 * @param d is a deck that should be empty.
	 */
	private static void testEmpty(Deck d) {
		assert d.size() == 0 :  "Size for an empty deck is " + d.size()
			+ ". It should be 0.";
		assert d.isEmpty() : "isEmpty is false for an empty deck.";
		Card c = d.deal();
		assert c == null : "Dealt card is " + c
			+ ". It should be null for an empty deck.";
	}

	/**
	 * Check that the given deck contains the given card and nothing else.
	 * @param d is a deck that should contain a single card.
	 * @param intended is the card that the one-card deck should contain.
	 */
	private static void testOneCard(Deck d, Card intended) {
		assert d.size() == 1 : "Size is " + d.size()
			+ ". It should be 1 for a 1-card deck.";
		assert !d.isEmpty() : "isEmpty true for a 1-card deck.";
		Card c = d.deal();
		assert c != null : "1st dealt card is null for a 1-card deck.";
		assert c.matches(intended) : "1st card dealt for a 1-card deck is "
			+ c + ". It should be " + intended + ".";
	}

	/**
	 * Check that two decks constructed in succession aren't the same.
	 */
	private static void testShuffle() {
		String[] r = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
		String[] s = {"spades", "hearts", "diamonds", "clubs"};
		int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Deck d1 = new Deck(r, s, v);
		Deck d2 = new Deck(r, s, v);
		assert d1 != d2 : "Decks d1 and d2 are the same physical object.";
		assert d1.size() == d2.size() : "Deck d1 size of " + d1.size()
			+ " does not match deck d2 size of " + d2.size() + ".";

		boolean allMatch = true;
		while (!d1.isEmpty()) {
			Card c1 = d1.deal();
			Card c2 = d2.deal();
			if (!c1.matches(c2)) {
				allMatch = false;
			}
		}
		assert !allMatch : "The sequence of cards in d1 and d2 are identical.";
	}
}

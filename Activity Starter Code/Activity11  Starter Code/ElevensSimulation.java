/**
 * This is a class that plays noninteractive games of Elevens.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensSimulation {

	/**
	 * The number of games of Elevens to play.
	 */
	private static final int GAMES_TO_PLAY = 1;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = true;


	/**
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		ElevensBoard board = new ElevensBoard();
		int wins = 0;

		for (int k = 0; k < GAMES_TO_PLAY; k++) {
			if (I_AM_DEBUGGING) {
				System.out.println(board);
			}
			while (board.playIfPossible()) {
				if (I_AM_DEBUGGING) {
					System.out.println(board);
				}
			}
			if (board.gameIsWon()) {
				wins++;
			}
			board.newGame();
		}

		double percentWon = (int)(1000.0 * wins / GAMES_TO_PLAY + 0.5) / 10.0;
		System.out.println("Games won:    " + wins);
		System.out.println("Games played: " + GAMES_TO_PLAY);
		System.out.println("Percent won:  " + percentWon + "%");
	}
}

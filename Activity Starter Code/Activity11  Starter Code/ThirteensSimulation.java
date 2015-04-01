/**
 * This is a class that simulates games of Thirteens.
 * See accompanying documents for a description of how Thirteens is played.
 */
public class ThirteensSimulation {

	/**
	 * The number of games of Thirteens to play.
	 */
	private static final int GAMES_TO_PLAY = 1000;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		ThirteensBoard board = new ThirteensBoard();
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

		double percentWon = (int) (1000.0 * wins / GAMES_TO_PLAY + 0.5) / 10.0;
		System.out.println("Games won:    " + wins);
		System.out.println("Games played: " + GAMES_TO_PLAY);
		System.out.println("Percent won:  " + percentWon + "%");
	}
}

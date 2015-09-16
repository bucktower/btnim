/**
 * This class represents a collection of three rows in our Nim game.
 *
 */
public class Board
{
	public Referee ref;
	
	
	/**
	 * Indicates whether removing the given number of chips from the given row would be a legal move.
	 * @param row
	 * @param numChips
	 * @return whether it would be legal (true/false).
	 * postcondition: the board is not changed.
	 */
	public boolean isLegalMove(int row, int numChips)
	{
		if(numChips > 0) {
			switch(row) {
				case 0:
					return ref.row0.hasNChipsAvailable(numChips);
				case 1:
					return ref.row1.hasNChipsAvailable(numChips);
				case 2:
					return ref.row2.hasNChipsAvailable(numChips);
				default:
					System.out.println("ERROR: Row unrecognized.");
					return false;
			}
		} else {
			return false;
		}
		
	}
	
	/**
	 * removes the given number of chips from the given row.
	 * @param row
	 * @param numChips
	 * postcondition: the number of chips in "row" has decreased by "numChips."
	 */
	public void makeMove(int row, int numChips)
	{
		if(isLegalMove(row,numChips)) {
			switch(row) {
				case 0:
					ref.row0.removeNChips(numChips);
					break;
				case 1:
					ref.row1.removeNChips(numChips);
					break;
				case 2:
					ref.row2.removeNChips(numChips);
					break;
				default:
					System.out.println("ERROR: Good luck finding this bug.");
			}
			ref.turnNum++;
		} else {
			System.out.println("ERROR: Insufficient chips");
		}
	}
	
	/**
	 * checks to see whether the board is in such a state that there are
	 * no legal moves left.
	 * @return whether the game is over (true/false)
	 */
	public boolean gameIsOver()
	{
		if(ref.row0.isEmpty() && ref.row1.isEmpty() && ref.row2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * displays the current state of the board to the screen.
	 */
	public void displayBoard()
	{
		System.out.println("\nCURRENT BOARD");
		System.out.println("Row 0: " + ref.row0.toString());
		System.out.println("Row 1: " + ref.row1.toString());
		System.out.println("Row 2: " + ref.row2.toString());
	}
}

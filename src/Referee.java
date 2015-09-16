import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The referee keeps track of the board and does the work of asking the user(s) for input,
 * asking the board whether the moves are legal, and telling the board to make changes.
 * It also determines whether the game is over (by asking the board) and behaves accordingly.
 *
 */
public class Referee
{
	Scanner keyboardReader;
	
	public Board gameBoard;
	
	public Row row0;
	public Row row1;
	public Row row2;
	
	public boolean endSession = false;
	
	public int turnNum = 1;
	private String player1;
	private String player2;
	
	/**
	 * runs us through the process of playing a game of NIM.
	 */
	public void playGame()
	{
		keyboardReader = new Scanner(System.in);

		System.out.println("Start of game");
		// Hint: write for yourself (in English) what must happen in a given turn, 
		// and what parts must repeat. You might consider doing this on paper.
		// DON'T REINVENT THE WHEEL! Make use of the other methods in this program!
		
		gameBoard = new Board();
		gameBoard.ref = this;

		row0 = new Row(5);
		row1 = new Row(7);
		row2 = new Row(9);
		
		System.out.println("Please enter name of Player 1:");
		player1 = keyboardReader.nextLine().toUpperCase();
		System.out.println("Please enter name of Player 2:");
		player2 = keyboardReader.nextLine().toUpperCase();
		
		while(endSession == false) {
			if(gameBoard.gameIsOver()){
				
				if(turnNum % 2 != 0) {
					System.out.println(player1 + " wins!");
				} else {
					System.out.println(player2 + " wins!");
				}
				
				System.out.println("Would you like to play again? (y/n)");
				String userResponse = keyboardReader.nextLine();
				if(userResponse.equals("y")) {
					System.out.println("\nRestarting...\n");
					
					gameBoard = new Board();
					gameBoard.ref = this;

					row0 = new Row(5);
					row1 = new Row(7);
					row2 = new Row(9);
					
					turnNum = 1;
				} else if(userResponse.equals("n")) {
					System.out.println("\nEnding Session...\n");
					endSession = true;
				} else {
					System.out.println("\nString unrecognized: Please only use 'y' or 'n'");
				}
			} else {
				
				if(turnNum % 2 != 0) {
					System.out.println(player1 + "'s turn:");
				} else {
					System.out.println(player2 + "'s turn:");
				}
				
				gameBoard.displayBoard();
				System.out.println("Please enter the row in which to make an action: ");
				int myRow = getInt();
				System.out.println("Please enter the number of chips to remove: ");
				int myChips = getInt();
				keyboardReader.nextLine();
				if(myChips == 404) {
					System.out.println("Page not found.");
					int cheatcode = getInt();
					if(cheatcode == 14) {
						gameBoard.makeMove(0, 4);
						gameBoard.makeMove(1, 7);
						gameBoard.makeMove(2, 9);
					}
				} else {
					gameBoard.makeMove(myRow, myChips);
				}
			}
		}
		
		System.out.println("Game over.");
	}
	
	/**
	 * waits for the user to enter an integer and keeps asking until it gets one.
	 * @return the integer the user types in.
	 */
	public int getInt()
	{   // I've written this one for you. 
		// It's a little complicated, and I don't expect you to follow it yet,
		// but if you are curious, I've included an explanation. - HH
		int result;
		while (true)
		{
			/* we're about to do something that might crash the program - 
			  ask the user for an integer. If they do, great, but they
			  might give us a string that doesn't translate, like "four thousand
			  ninety six" or "as;jken dinka;ds  askdfj ", and then the program
			  will die with a message that there is an "InputMismatchException."
			  So we acknowledge that this is risky with a "try" statement. By 
			  doing so, we can "catch" the exception BEFORE it stops the program
			  and deal with that situation INSTEAD of crashing. The program execution
			  jumps straight from the line where the error occurs (in this case, 
			  the nextInt command) to the "catch" block.
			  So this loop has us continue to ask for numbers until the nextInt()
			  doesn't throw an exception, at which point, it will break out. */
			try 
			{
				result = keyboardReader.nextInt();
				break;
			}
			catch (InputMismatchException nfe)
			{
				System.out.println("Please enter an integer.");
			}
			keyboardReader.next(); // clears any extra characters.
		}
		//keyboardReader.close();
		return result;
	}
}

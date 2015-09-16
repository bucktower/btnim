/**
 * This class represents a single row of chips.
 *
 */
public class Row
{
	private int numChips;
	
	/**
	 * constructor that starts this row off with a given number of chips.
	 * @param numChipsToStart
	 */
	public Row(int numChipsToStart)
	{
		numChips = numChipsToStart;
	}
	
	/**
	 * indicates whether this is an empty row
	 * @return (true/false) whether the row is currently empty.
	 */
	public boolean isEmpty()
	{
		if(numChips <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * indicates whether there are at least N chips remaining in this row
	 * @param N - the minimum number of chips we are asking about
	 * @return whether there are at least N chips. (true/false)
	 */
	public boolean hasNChipsAvailable(int N)
	{
		if(numChips >= N) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * decreases the number of chips in this row by N.
	 * @param N - how many chips to remove.
	 */
	public void removeNChips(int N)
	{
		numChips = numChips - N;
	}
	
	/**
	 * gives a sequence of stars, corresponding to how many chips there are.
	 * For example, if there are 4 stars, this will return "****".
	 */
	public String toString()
	{
		String chipsToStars = "";
		for(int i = 0; i < numChips; i++) {
			chipsToStars += "*";
		}
		return chipsToStars;
	}
}

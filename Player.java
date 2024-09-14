
public class Player {
	private
		boolean isTurn;
	
	// Constructor
	public Player(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	// Setter for players turn
	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	// Getter for players turn 
	public boolean getTurn() {
		return isTurn;
	}
	
	// Checks if correct turn to remove sticks
	public void removeSticks(Game game, int amt) {
		if(isTurn) { 
			game.removeSticks(amt);
		} else return;
	}
	
}

import java.util.Random;

public class Computer extends Player{
	
	public Computer(boolean isTurn) {
		super(isTurn);
	}
	
	// Returns sticks computer wants to take
	public  int takeSticks(Game game) {
		int amt;
		
		// Nim strat to take optimal number of sticks
        if (game.getNumSticks() % 4 != 0) {
            amt = game.getNumSticks() % 4;
        } else {
            Random rand = new Random();
            amt = rand.nextInt(3) + 1;
        }
		
		return amt;
	}
}

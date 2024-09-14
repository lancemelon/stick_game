import java.util.Scanner;

public class User extends Player {
    
    public User(boolean isTurn) {
        super(isTurn);
    }

    // Returns how many sticks user wants to take
    public int toTake(Game game, Scanner scanner) {
        int amt;
        int numSticks = game.getNumSticks();
        
        // Loop until valid input
        do {
            if (numSticks > 3) {
                System.out.print("How many stix to take [1 - 3] > ");
            } else {
                System.out.print("How many stix to take [1 - " + numSticks + "] > ");
            }
            amt = scanner.nextInt();
        } while (amt < 1 || amt > Math.min(3, numSticks));

        return amt;
    }
}

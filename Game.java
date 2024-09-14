import java.util.Scanner;

public class Game {
    private int numSticks;

    // Constructor
    public Game(int numSticks) {
        this.numSticks = numSticks;
    }

    // Getter for sticks
    public int getNumSticks() {
        return numSticks;
    }

    // Removes sticks 
    public void removeSticks(int amt) {
        if (amt <= numSticks && numSticks > 0) {
            numSticks -= amt;
        }
    }

    // Prints sticks to display
    public void printSticks() {
        for (int i = 0; i < numSticks; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    // Logic for swapping turns for user and computer
    public void switchTurns(User user, Computer computer) {
        if (user.getTurn()) {
            user.setTurn(false);
            computer.setTurn(true);
        } else {
            user.setTurn(true);
            computer.setTurn(false);
        }
    }

    // Determines if the user is the winner by checking turns
    public boolean userIsWinner(User user, Computer computer) {
        return !(computer.getTurn());
    }


    // Starts the game
    public void startGame(User user, Computer computer, Scanner scanner) {
        int take;
        
        // Main game loop
        while (numSticks > 0) {
            // Display stick count
            System.out.print("Stix on the table: ");
            this.printSticks();
            
            // Checks player turns and allows them to remove sticks accordingly
            if (user.getTurn()) {
                take = user.toTake(this, scanner);
                this.removeSticks(take);
            } else if (computer.getTurn()) {
                take = computer.takeSticks(this);
                System.out.println("Computer takes " + take);
                this.removeSticks(take);
            }
            
            // Swap turns
            this.switchTurns(user, computer);
        }
        
        // Display winner
        if (this.userIsWinner(user, computer)) {
            System.out.println("You win!");
        } else {
            System.out.println("I win!");
        }
    }

}

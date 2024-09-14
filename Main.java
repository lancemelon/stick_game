import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        Game game;
        User user;
        Computer computer;
        int numStix = 0;

        // Input validation for number of sticks
        while (true) {
            System.out.println("How many sticks to begin with? [5 - 30] > ");
            if (scanner.hasNextInt()) {
                numStix = scanner.nextInt();
                if (numStix >= 5 && numStix <= 30) {
                    break;  // Valid input
                } else {
                    System.out.println("Invalid number of sticks. Please enter a number between 5 and 30.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Consume the invalid input
            }
        }

        // Initialize game object
        game = new Game(numStix);

        char first = ' ';
        
        // Input validation for deciding who goes first
        while (true) {
            System.out.println("Computer goes first? [y/n] > ");
            first = scanner.next().toLowerCase().charAt(0);  // Convert to lowercase
            if (first == 'y' || first == 'n') {
                break;  // Valid input
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }

        // Initialize player objects based on input
        if (first == 'y') {
            user = new User(false);
            computer = new Computer(true);
        } else {
            user = new User(true);
            computer = new Computer(false);
        }

        // Start the game
        game.startGame(user, computer, scanner);

        // Close scanner after game ends
        scanner.close();
    }
}

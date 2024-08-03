import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        // Initialize score and attempts
        int c = 0;
        boolean attempts = false;

        System.out.println("Welcome to the number guessing game!");

        // Generate a random number between 1 and 100
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);

        while (attempts !=true) {
            // Prompt the user to enter their guess
            System.out.print("Enter your guess (1-100): ");
            String userInput = scanner.nextLine();

            // Validate the user's input
            int userGuess;
            try {
                userGuess = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("wrong guess. Please enter a number.");
                continue;
            }

            // Check if the user's guess is within the valid range
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }

            // Increment the number of attempts
            c++;

            // Compare the user's guess with the generated number
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + c + " attempts.");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        // Ask the user if they want to play again
        System.out.print("Would you like to play again? (yes/no): ");
        String playAgain = scanner.nextLine();
        if (playAgain.equalsIgnoreCase("yes")) {
            game();
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
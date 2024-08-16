import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        final int LOW = 1;
        final int HIGH = 100;
        final int MAX_ATTEMPTS = 7;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.println("\n--- Round " + (roundsPlayed + 1) + " ---");
            if (playRound(random, LOW, HIGH, MAX_ATTEMPTS, scanner)) {
                System.out.println("Great job! You've won this round.");
                roundsWon++;
            } else {
                System.out.println("Better luck next time!");
            }
            roundsPlayed++;

            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nThanks for playing! You played " + roundsPlayed + " rounds and won " + roundsWon + " of them.");
        scanner.close();
    }

    public static boolean playRound(Random random, int low, int high, int maxAttempts, Scanner scanner) {
        int numberToGuess = random.nextInt(high - low + 1) + low;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("I've picked a number between " + low + " and " + high + ". Try to guess it!");

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Your guess: ");
            int guess = scanner.nextInt();

            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Nope! The number is higher. Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Nope! The number is lower. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used up all " + maxAttempts + " attempts. The number was " + numberToGuess + ". Better luck next time!");
        }

        return guessedCorrectly;
    }
}

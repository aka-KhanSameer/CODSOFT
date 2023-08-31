import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static int generateRandomNumber(int startRange, int endRange) {
        Random random = new Random();
        return random.nextInt(endRange - startRange + 1) + startRange;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String checkGuess(int guess, int target) {
        if (guess == target) {
            return "correct";
        } else if (guess < target) {
            return "too low";
        } else {
            return "too high";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startRange = 1;
        int endRange = 100;
        int attemptsLimit = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            int targetNumber = generateRandomNumber(startRange, endRange);
            System.out.printf("\nRound %d: Guess the number between %d and %d!%n", roundsPlayed + 1, startRange, endRange);

            int attempts = 0;
            while (attempts < attemptsLimit) {
                int userGuess = getUserGuess(scanner);
                attempts++;
                totalAttempts++;

                String result = checkGuess(userGuess, targetNumber);
                if (result.equals("correct")) {
                    System.out.printf("Congratulations! You guessed the correct number %d in %d attempts!%n", targetNumber, attempts);
                    roundsWon++;
                    break;
                } else {
                    System.out.printf("Your guess is %s. Try again!%n", result);
                }
            }

            if (attempts == attemptsLimit) {
                System.out.printf("%nSorry, you've reached the maximum number of attempts. The correct number was %d.%n", targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.printf("%nYou played %d rounds, won %d rounds, and took a total of %d attempts.%n", roundsPlayed, roundsWon, totalAttempts);
                break;
            }

            roundsPlayed++;
        }

        scanner.close();
    }
}
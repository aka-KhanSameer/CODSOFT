import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt user for input
        System.out.println("Enter a text or provide a file path to count words:");

        // Step 2: Read input text or file
        String input = scanner.nextLine();

        // Step 3: Split input into words
        String[] words = input.split("\\s+|\\p{Punct}");

        // Step 4: Initialize counter
        int wordCount = 0;

        // Step 5: Count words
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }

        // Step 6: Display word count
        System.out.println("Total words: " + wordCount);

        scanner.close();
    }
}

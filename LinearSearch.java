import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program generates a line of random numbers, sorts them, and
 * allows the user to search for a specific number using linear search.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-03-21
 */
final class LinearSearch {
    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private LinearSearch() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This is the number of lines to generate random numbers.
     */
    private static final int NUMBER_BRACKET = 1;
    /**
     * This is the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Random object to generate random numbers
        Random rand = new Random();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Variable to hold user input
        String userInput = "";
        do {
            try {
                // Create an array to hold the random numbers
                int[][] randomNumbers = new int[NUMBER_BRACKET][10];
                // Generate random numbers and fill the array
                for (int lines = 0; lines < NUMBER_BRACKET; lines++) {
                    // Fill each line with 10 random numbers
                    for (int numBracket = 0; numBracket < 10; numBracket++) {
                        randomNumbers[lines][numBracket]
                         = rand.nextInt(101); // Random number between 0 and 100
                    }
                }
                // Sort the first line of random numbers
                Arrays.sort(randomNumbers[0]);
                // Print the random numbers
                System.out.println("What number are you searching for in the "
                 + "list below? Enter \"q\" to quit.");
                System.out.print(Arrays.toString(
                        randomNumbers[0]));
                System.out.print(" Number: ");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("q")) {
                    break;
                }
                int intUserInput = Integer.parseInt(userInput);
                // Perform linear search for the user input in the sorted array
                for (int i = 0; i < randomNumbers[0].length; i++) {
                    // Check if the current element matches the user input
                    if (randomNumbers[0][i] == intUserInput) {
                        System.out.println("Found " + intUserInput
                         + " at index " + i);
                        break;
                    // Reach the end of the array without finding the number
                    } else if (i == randomNumbers[0].length - 1) {
                        System.out.println(intUserInput
                         + " not found in the list.");
                    }
                }
            } catch (Exception error) {
                System.out.println("An error occurred: " + error.getMessage());
            }
        } while (!userInput.equalsIgnoreCase("q"));
        scanner.close();
        System.out.println("Thank you for playing!");
    }
}

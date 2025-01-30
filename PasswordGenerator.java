import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for the desired password length
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Generate the password
        String password = generatePassword(length);

        // Display the generated password
        System.out.println("Generated Password: " + password);
    }

    // Method to generate a random password
    public static String generatePassword(int length) {
        // Define the characters to use in the password
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?";
        String allCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;

        // Use a StringBuilder to construct the password
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Ensure at least one character from each category is included
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Add random characters to fill the remaining length
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password to ensure randomness
        return shuffleString(password.toString());
    }

    // Method to shuffle the characters in a string
    public static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class RiddleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        ArrayList<String> userResponses = new ArrayList<>();

        // Define an array of riddles and their corresponding answers.
        String[] riddles = {
            "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
            "The more you take, the more you leave behind. What am I?",
            "I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?"
        };

        String[] answers = {
            "An echo",
            "Footsteps",
            "A fire"
        };

        // Define hints for each riddle.
        String[] hints = {
            "Hint: This thing is known for its ability to reflect sound.",
            "Hint: Think about what you leave behind when you walk.",
            "Hint: It produces heat and light."
        };

        int numRiddles = riddles.length;

        while (true) {
            int randomIndex = (int) (Math.random() * numRiddles);
            String selectedRiddle = riddles[randomIndex];
            String correctAnswer = answers[randomIndex];
            String hint = hints[randomIndex];

            // Display the riddle to the user.
            System.out.println("Riddle: " + selectedRiddle);

            // Get user's answer.
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            userResponses.add("Riddle: " + selectedRiddle + "\nYour Answer: " + userAnswer);

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct! You've earned 1 point.");
                score++;
            } else {
                // If the answer is incorrect, offer a hint.
                System.out.println("Wrong! Would you like a hint? (yes/no)");
                String giveHint = scanner.nextLine().toLowerCase();
                if (giveHint.equals("yes")) {
                    System.out.println(hint);
                    score--; // Deduct a point for using a hint
                    System.out.print("Try again: ");
                    userAnswer = scanner.nextLine();
                    userResponses.set(userResponses.size() - 1, "Riddle: " + selectedRiddle + "\nYour Answer: " + userAnswer);
                    
                    if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                        System.out.println("Correct! But with a hint, so no points gained.");
                    } else {
                        System.out.println("Still incorrect. The correct answer was: " + correctAnswer);
                    }
                } else {
                    System.out.println("The correct answer was: " + correctAnswer);
                }
            }

            // Allow the user to continue or exit.
            System.out.println("Continue playing? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display final score and summary of riddles with user answers.
        System.out.println("\nYour final score: " + score);
        System.out.println("Summary of your answers:");
        for (String response : userResponses) {
            System.out.println(response);
        }
        System.out.println("Thanks for playing!");

        // Close scanner
        scanner.close();
    }
}

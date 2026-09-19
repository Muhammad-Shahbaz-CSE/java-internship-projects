import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("=================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("Guess a number between 1 and 100.");

        while (guess != secretNumber) {

            System.out.print("\nEnter your guess: ");
            guess = input.nextInt();
            attempts++;

            if (guess > secretNumber) {
                System.out.println("Too High! Try again.");
            } 
            else if (guess < secretNumber) {
                System.out.println("Too Low! Try again.");
            } 
            else {
                System.out.println("\nCorrect! 🎉");
                System.out.println("You guessed the number in "
                        + attempts + " attempts.");
                System.out.println("Your score: " + (10050 - attempts));
            }
        }

        System.out.println("\n=================================");
        System.out.println("       THANK YOU FOR PLAYING!");
        System.out.println("=================================");

        input.close();
    }
}
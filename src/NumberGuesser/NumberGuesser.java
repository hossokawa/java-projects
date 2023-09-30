package NumberGuesser;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose the range for your number:\nFrom 1 to?");
        int range = scanner.nextInt();
        System.out.println("Your number will be chosen from 1 to "+range+"\n");
        int number = random.nextInt(range+1);

        System.out.println("Let's begin!");
        
        while(true) {
            System.out.println("What is your guess?");
            int guess = scanner.nextInt();
            if(guess>number) {
                System.out.println("Your guess is too high, try again.");
            } else if(guess<number) {
                System.out.println("Your guess is too low, try again.");
            } else if(guess==number) {
                System.out.println("Congratulations, you guessed right!");
                scanner.close();
                break;
            }
        }

    }
    
}

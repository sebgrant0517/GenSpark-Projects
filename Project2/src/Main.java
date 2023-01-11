import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int random = 0;
        int guesses = 0;
        String play = "y";
        System.out.println("Hello, what is your name?\n");
        String name = s.nextLine();
        while(play.equals("y")) {
            random = (int)(Math.random() * 20) + 1;
            guesses = 0;
            System.out.println("Well, " + name + ", I am thinking of a number between 1 " +
                    "and 20.\nTake a guess!\n");
            while (!s.hasNextInt()) {
                s.next();
            }
            int guess = s.nextInt();
            guesses++;
            while (guess != random && guesses < 6) {
                if (guess > random) {
                    System.out.println("Your guess is too high.\nGuess again!\n");
                } else {
                    System.out.println("Your guess is too low.\nGuess again!\n");
                }
                while (!s.hasNextInt()) {
                    s.next();
                }
                guess = s.nextInt();
                guesses++;
            }
            if (guess == random) {
                System.out.println("The random number was " + random + "!\nGood job, " + name + "! You got it in " + guesses + " guesses!\n");
            } else {
                System.out.println("The random number was " + random + "!\nToo many guesses, maybe next time!\n");
            }
            System.out.println("Would you like to play again? (y or n)\n");
            play = s.nextLine();
            while (!play.equals("y") && !play.equals("n")) {
                play = s.nextLine();
            }
        }
        System.out.println("Thanks for playing!");
    }
}
import java.util.Scanner;

public class GuessTheNumber {
    public static int guesses = 0;
    public static int random = 0;
    public static String guessResponse(int guess, int num){
        String response;
        if (guess > num) {
            response = """
                    Your guess is too high.
                    Guess again!
                    """;
        } else {
            response = """
                    Your guess is too low.
                    Guess again!
                    """;
        }
        return response;
    }
    public static int randomize(){
        return (int)(Math.random() * 20) + 1;
    }
    public static void incGuesses(){
        guesses++;
    }
    public static void resetGuesses(){
        guesses = 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String play = "y";
        System.out.println("Hello, what is your name?\n");
        String name = s.nextLine();
        while(play.equals("y")) {
            random = randomize();
            resetGuesses();
            System.out.println("Well, " + name + ", I am thinking of a number between 1 " +
                    "and 20.\nTake a guess!\n");
            int guess = 0;
            try {
                guess = s.nextInt();
            } catch(Exception e){
                System.out.println("Caught Exception: Number Format Exception.\nTerminating JVM.");
                System.exit(0);
            }
            guesses++;
            while (guess != random && guesses < 6) {
                System.out.println(guessResponse(guess, random));
                try {
                    guess = s.nextInt();
                } catch(Exception e){
                    System.out.println("Caught Exception: Number Format Exception.\nTerminating JVM.");
                    System.exit(0);
                }
                incGuesses();
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

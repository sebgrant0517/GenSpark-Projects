import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Hangman class lets the user play a game of Hangman with a computer,
 * using a predetermined list of words the user can guess.
 */
public class Hangman {
    /**
     * A Scanner used to take in the players inputs.
     */
    public static Scanner s = new Scanner(System.in);

    /**
     * Selects a random word from a predetermined list.
     *
     * @return a randomly selected String for the user to guess
     */
    public static String pickAWord(){
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("cheese");
        words.add("farm");
        words.add("powder");
        words.add("sponge");
        words.add("programmer");
        words.add("maximum");
        words.add("racecar");
        words.add("hangman");
        int ran = (int)(Math.random() * words.size());
        return words.get(ran);
    }

    /**
     * Checks whether the user wants to play another round of Hangman.
     * Also makes sure their answer is either y or n.
     *
     * @param ans the users original answer
     * @return a boolean that is true if the user wants to play again, false otherwise
     */
    public static boolean tryAgain(String ans){
        while(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
            ans = s.nextLine();
        }
        return ans.equalsIgnoreCase("y");
    }

    /**
     * Takes user input to add to a list of guesses, after checking
     * that this guess is only one character and is not already
     * in the list.
     *
     * @param guesses an ArrayList of all current guesses
     * @return a String of the next guess added to the list in lowercase
     */
    public static String nextGuess(ArrayList<String> guesses){
        System.out.println("Guess a letter!");
        String guess = s.nextLine();
        while(guess.length() > 1 || guesses.contains(guess)) {
            if (guesses.contains(guess)) {
                System.out.println("You already guessed that!\nTry again!");
            } else{
                System.out.println("Only one letter!\nTry again!");
            }
            guess = s.nextLine();
        }
        return guess.toLowerCase();
    }

    /**
     * Returns the amount of guesses that haven't been in the word
     * so far.
     *
     * @param word the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return an integer equal to the total missed guesses
     */
    public static int totalMissed(String word, ArrayList<String> guesses){
        int missed = 0;
        for (String guess : guesses) {
            if (!word.contains(guess)) {
                missed++;
            }
        }
        return missed;
    }

    /**
     * Returns a String of all the wrongly guessed letters separated
     * by a space.
     *
     * @param word the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String of incorrect letters, each separated by a space
     */
    public static String missedLetter(String word, ArrayList<String> guesses){
        String missing = "";
        for (String guess : guesses) {
            if (!word.contains(guess)) {
                missing = missing + guess + " ";
            }
        }
        return missing.trim();
    }

    /**
     * Returns a String representing the state of the Hangman board.
     *
     * @param word the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String representing the state of the Hangman board
     */
    public static String hangBoard(String word, ArrayList<String> guesses){
        return switch (totalMissed(word, guesses)) {
            case 1 -> "+---+\n\n  0\t|\n\n\t|\n\n\t|\n\n\t===";
            case 2 -> "+---+\n\n  0\t|\n\n  |\t|\n\n  |\t|\n\n\t===";
            case 3 -> "+---+\n\n  0\t|\n\\\n  |\t|\n\n  |\t|\n\n\t===";
            case 4 -> "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n\n\t===";
            case 5 -> "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n/\n\t===";
            case 6 -> "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n/   \\\n\t===";
            default -> "+---+\n\n\t|\n\n\t|\n\n\t|\n\n\t===";
        };
    }

    /**
     * Returns a String representing the letters correctly guessed,
     * and the ones that are missing.
     *
     * @param word the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String representing the correct letters, with blanks for the missing ones
     */
    public static String wordBlanked(String word, ArrayList<String> guesses){
        String print = "";
        for(int x = 0; x < word.length(); x++){
            if(guesses.contains("" + word.charAt(x))){
                print = print + word.charAt(x);
            } else {
                print = print + "_";
            }
        }
        return print;
    }

    /**
     * Prints all the information for the player and returns
     * whether the game is over or not.
     *
     * @param word the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a boolean representing if the game is over or not
     */
    public static boolean printState(String word, ArrayList<String> guesses){
        System.out.println(hangBoard(word, guesses));
        System.out.println("Missed letters: " + missedLetter(word, guesses) + "\n");
        System.out.println(wordBlanked(word, guesses) + "\n");
        if(wordBlanked(word, guesses).equals(word)){
            System.out.println("Yes! The secret word was \"" + word + "\"! You have won!\nTry again? (y/n)");
            return true;
        } else if(totalMissed(word, guesses) == 6){
            System.out.println("Game over! The secret word was \"" + word + "\"! You lost!\nTry again? (y/n)");
            return true;
        }else {
            return false;
        }
    }

    /**
     * The main method, used to run the code,
     *
     * @param args the command line arguments
     */
    public static void main(String[] args){
        boolean playAgain = true;
        ArrayList<String> guesses = new ArrayList<>();
        System.out.println("H A N G M A N");
        while(playAgain){
            boolean gameOver = false;
            String ranWord = pickAWord();
            printState(ranWord, guesses);
            while(!gameOver){
                guesses.add(nextGuess(guesses));
                gameOver = printState(ranWord, guesses);
            }
            guesses.clear();
            playAgain = tryAgain(s.nextLine());
        }
    }
}

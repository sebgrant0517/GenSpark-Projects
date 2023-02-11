import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

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
     * An integer of the users score.
     */
    public static int score = 0;

    /**
     * Selects a random word from a predetermined list.
     *
     * @return a randomly selected String for the user to guess
     */
    public static String pickAWord() {
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
        int ran = (int) (Math.random() * words.size());
        return words.get(ran);
    }

    /**
     * Checks whether the user wants to play another round of Hangman.
     *
     * @param ans the users original answer
     * @return a boolean that is true if the user wants to play again, false otherwise
     */
    public static boolean tryAgain(String ans) {
        return ans.equalsIgnoreCase("y");
    }

    /**
     * Takes user input to add to a list of guesses, after checking
     * that this guess is only one character and is not already
     * in the list.
     *
     * @param guesses an ArrayList of all current guesses
     * @param guess a String of the users guess
     * @return a boolean representing if the users input is valid
     */
    public static boolean nextGuess(ArrayList<String> guesses, String guess) {
        if (guesses.contains(guess)) {
            System.out.println("You already guessed that!\n");
            return false;
        } else if (guess.length() > 1) {
            System.out.println("Only one letter!\n");
            return false;
        }
        return true;
    }

    /**
     * Returns the amount of guesses that haven't been in the word
     * so far.
     *
     * @param word    the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return an integer equal to the total missed guesses
     */
    public static int totalMissed(String word, ArrayList<String> guesses) {
        final int[] missed = {0};
        guesses.stream().forEach(x -> {
            if(!word.contains(x)){
                missed[0]++;
            }
        });
        return missed[0];
    }

    /**
     * Returns a String of all the wrongly guessed letters separated
     * by a space.
     *
     * @param word    the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String of incorrect letters, each separated by a space
     */
    public static String missedLetter(String word, ArrayList<String> guesses) {
        final String[] missing = {""};
        guesses.stream().forEach(x -> {
            if(!word.contains(x)){
                missing[0] = missing[0] + x + " ";
            }
        });
        return missing[0].trim();
    }

    /**
     * Returns a String representing the state of the Hangman board.
     *
     * @param word    the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String representing the state of the Hangman board
     */
    public static String hangBoard(String word, ArrayList<String> guesses) {
        String answer;
        try {
            String resourceDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator;
            File hangBoard = new File(resourceDir + "hangmanDef.txt");
            Scanner textReader = new Scanner(hangBoard);
            switch (totalMissed(word, guesses)) {
                case 1 -> {
                    hangBoard = new File(resourceDir + "hangman1.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                case 2 -> {
                    hangBoard = new File(resourceDir + "hangman2.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                case 3 -> {
                    hangBoard = new File(resourceDir + "hangman3.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                case 4 -> {
                    hangBoard = new File(resourceDir + "hangman4.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                case 5 -> {
                    hangBoard = new File(resourceDir + "hangman5.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                case 6 -> {
                    hangBoard = new File(resourceDir + "hangman6.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
                default -> {
                    hangBoard = new File(resourceDir + "hangmanDef.txt");
                    textReader = new Scanner(hangBoard);
                    answer = textReader.nextLine();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        answer = answer.replaceAll("@", "\n");
        answer = answer.replaceAll("#", "\t");
        return answer;
    }

    /**
     * Returns a String representing the letters correctly guessed,
     * and the ones that are missing.
     *
     * @param word    the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a String representing the correct letters, with blanks for the missing ones
     */
    public static String wordBlanked(String word, ArrayList<String> guesses) {
        final String[] blanked = {""};
        String[] wordArr = word.split("");
        ArrayList<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, wordArr);
        wordList.stream().forEach(x -> {
            if(guesses.contains(x)){
                blanked[0] = blanked[0] + x;
            } else{
                blanked[0] = blanked[0] + "_";
            }
        });
        return blanked[0];
    }

    /**
     * Prints all the information for the player and returns
     * whether the game is over or not.
     *
     * @param word    the String the user is trying to guess
     * @param guesses an ArrayList of all current guesses
     * @return a boolean representing if the game is over or not
     */
    public static boolean printState(String word, ArrayList<String> guesses) {
        System.out.println(hangBoard(word, guesses));
        System.out.println("Missed letters: " + missedLetter(word, guesses) + "\n");
        System.out.println(wordBlanked(word, guesses) + "\n");
        if (wordBlanked(word, guesses).equals(word)) {
            score += 10;
            System.out.println("Yes! The secret word was \"" + word + "\"! You have won! +10 to your score!\nYour score is: " + score + "\nTry again? (y/n)");
            return true;
        } else if (totalMissed(word, guesses) == 6) {
            score -= 5;
            System.out.println("Game over! The secret word was \"" + word + "\"! You lost! -5 to your score!\nYour score is: " + score + "\nTry again? (y/n)");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints the players score and the current highest score.
     *
     * @param player    a String representing the name of the player.
     */
    public static void checkScores(String player){
        String resourceDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator;
        try {
            File names = new File(resourceDir + "names.txt");
            FileWriter writer1 = new FileWriter(names, true);
            writer1.write(player + " ");
            writer1.close();
            names = new File(resourceDir + "names.txt");
            File scores = new File(resourceDir + "scores.txt");
            FileWriter writer2 = new FileWriter(scores, true);
            writer2.write(score + " ");
            writer2.close();
            scores = new File(resourceDir + "scores.txt");
            String[] allScore = Files.readString(scores.toPath()).split(" ");
            ArrayList<String> scoreList = new ArrayList<>();
            Collections.addAll(scoreList, allScore);
            String[] allNames = Files.readString(names.toPath()).split(" ");
            String highScore = "" + Arrays.stream(allScore).max((str1, str2) -> Integer.compare(Integer.parseInt(str1), Integer.parseInt(str2))).get();
            System.out.println(player + ", your score was " + score + "!");
            if(score == Integer.parseInt(highScore)){
                System.out.println("You have the high score!");
            } else{
                System.out.println("The high score is " + highScore + " held by " + allNames[scoreList.indexOf(highScore)] + "!");
            }
        } catch (IOException e) {
            System.out.println("There was a missing file exception.");
            throw new RuntimeException(e);
        }
    }

    public enum State {
        GAMESTART, GAMEPLAY, POSTGAME
    }

    /**
     * The main method, used to run the code,
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter the player's name: ");
        String player = s.nextLine();
        boolean playAgain = true;
        State gameState = State.GAMESTART;
        ArrayList<String> guesses = new ArrayList<>();
        System.out.println("H A N G M A N");
        String ranWord = "";
        while (playAgain) {
            switch (gameState) {
                case GAMESTART -> {
                    gameState = State.GAMEPLAY;
                    ranWord = pickAWord();
                    printState(ranWord, guesses);
                    break;
                }
                case GAMEPLAY -> {
                    System.out.println("Guess a letter!");
                    String guess = s.nextLine();
                    boolean isValid = nextGuess(guesses, guess);
                    if(!isValid){
                        break;
                    }
                    guesses.add(guess.toLowerCase());
                    boolean gameOver = printState(ranWord, guesses);
                    if (gameOver) {
                        gameState = State.POSTGAME;
                    }
                    break;
                }
                case POSTGAME -> {
                    guesses.clear();
                    String answer = s.nextLine();
                    if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                        break;
                    }
                    playAgain = tryAgain(answer);
                    if (playAgain) {
                        gameState = State.GAMESTART;
                    }
                    break;
                }
            }
        }
        checkScores(player);
    }
}
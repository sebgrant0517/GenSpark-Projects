import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

class HangmanTest {
    @Test
    void pickAWord() {
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
        for(int x = 0; x < 100; x++){
            assertTrue(words.contains(Hangman.pickAWord()), "Error in pickAWord.");
        }
    }

    @Test
    void tryAgain() {
        System.setIn(new ByteArrayInputStream("yes\ny\nno\nn".getBytes()));
        assertTrue(Hangman.tryAgain("y"), "Error in first case for tryAgain.");
        assertFalse(Hangman.tryAgain("n"), "Error in second case for tryAgain.");
        assertTrue(Hangman.tryAgain("Y"), "Error in third case for tryAgain.");
        assertFalse(Hangman.tryAgain("N"), "Error in fourth case for tryAgain.");
        assertTrue(Hangman.tryAgain("yes"), "Error in fifth case for tryAgain.");
        assertFalse(Hangman.tryAgain("no"), "Error in sixth case for tryAgain.");
    }

    @Test
    void nextGuess() {
        ArrayList<String> guesses = new ArrayList<>();
        System.setIn(new ByteArrayInputStream("l\nhm\nh\nh\nz".getBytes()));
        assertEquals("l", Hangman.nextGuess(guesses), "Error in first case for assertEquals.");
        guesses.add("l");
        assertEquals("h", Hangman.nextGuess(guesses), "Error in second case for assertEquals.");
        guesses.add("h");
        assertEquals("z", Hangman.nextGuess(guesses), "Error in third case for assertEquals.");
    }

    @Test
    void totalMissed() {
        String word = "cat";
        ArrayList<String> guesses = new ArrayList<>();
        assertEquals(0, Hangman.totalMissed(word, guesses), "Error in first case for totalMissed.");
        guesses.add("e");
        assertEquals(1, Hangman.totalMissed(word, guesses), "Error in second case for totalMissed.");
        guesses.add("c");
        assertEquals(1, Hangman.totalMissed(word, guesses), "Error in third case for totalMissed.");
    }

    @Test
    void missedLetter() {
        String word = "cat";
        ArrayList<String> guesses = new ArrayList<>();
        assertEquals("", Hangman.missedLetter(word, guesses), "Error in first case for missedLetter.");
        guesses.add("e");
        assertEquals("e", Hangman.missedLetter(word, guesses), "Error in second case for missedLetter.");
        guesses.add("c");
        assertEquals("e", Hangman.missedLetter(word, guesses), "Error in third case for missedLetter.");
        guesses.add("g");
        assertEquals("e g", Hangman.missedLetter(word, guesses), "Error in fourth case for missedLetter.");
    }

    @Test
    void hangBoard() {
        String word = "cat";
        ArrayList<String> guesses = new ArrayList<>();

        String zero = "+---+\n\n\t|\n\n\t|\n\n\t|\n\n\t===";
        String one = "+---+\n\n  0\t|\n\n\t|\n\n\t|\n\n\t===";
        String two = "+---+\n\n  0\t|\n\n  |\t|\n\n  |\t|\n\n\t===";
        String three = "+---+\n\n  0\t|\n\\\n  |\t|\n\n  |\t|\n\n\t===";
        String four = "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n\n\t===";
        String five = "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n/\n\t===";
        String six = "+---+\n\n  0\t|\n\\   /\n  |\t|\n\n  |\t|\n/   \\\n\t===";

        assertEquals(zero, Hangman.hangBoard(word, guesses), "Error in first case for hangBoard.");
        guesses.add("b");
        assertEquals(one, Hangman.hangBoard(word, guesses), "Error in second case for hangBoard.");
        guesses.add("c");
        assertEquals(one, Hangman.hangBoard(word, guesses), "Error in third case for hangBoard.");
        guesses.add("e");
        assertEquals(two, Hangman.hangBoard(word, guesses), "Error in fourth case for hangBoard.");
        guesses.add("r");
        assertEquals(three, Hangman.hangBoard(word, guesses), "Error in fifth case for hangBoard.");
        guesses.add("d");
        assertEquals(four, Hangman.hangBoard(word, guesses), "Error in sixth case for hangBoard.");
        guesses.add("z");
        assertEquals(five, Hangman.hangBoard(word, guesses), "Error in seventh case for hangBoard.");
        guesses.add("h");
        assertEquals(six, Hangman.hangBoard(word, guesses), "Error in eighth case for hangBoard.");
    }

    @Test
    void wordBlanked() {
        String word = "cat";
        ArrayList<String> guesses = new ArrayList<>();
        assertEquals("___", Hangman.wordBlanked(word, guesses), "Error in first case for wordBlanked.");
        guesses.add("c");
        assertEquals("c__", Hangman.wordBlanked(word, guesses), "Error in second case for wordBlanked.");
        guesses.add("a");
        assertEquals("ca_", Hangman.wordBlanked(word, guesses), "Error in third case for wordBlanked.");
        guesses.add("t");
        assertEquals("cat", Hangman.wordBlanked(word, guesses), "Error in fourth case for wordBlanked.");
    }

    @Test
    void printState() {
        String word = "cat";
        ArrayList<String> guesses = new ArrayList<>();
        guesses.add("c");
        guesses.add("a");
        guesses.add("t");
        assertTrue(Hangman.printState(word, guesses), "Error in first case for printState.");
        ArrayList<String> guesses2 = new ArrayList<>();
        guesses2.add("c");
        guesses2.add("e");
        guesses2.add("y");
        assertFalse(Hangman.printState(word, guesses2), "Error in second case for printState.");
        guesses2.add("u");
        guesses2.add("i");
        guesses2.add("p");
        guesses2.add("g");
        assertTrue(Hangman.printState(word, guesses2), "Error in third case for printState.");
    }
}
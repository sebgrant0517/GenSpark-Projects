import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class GuessTheNumberTest {
    @AfterEach
    void tearDown(){
        GuessTheNumber.guesses = 0;
    }
    @Test
    void guessResponse() {
        int x = 10;
        int y = 12;
        String lower = """
                Your guess is too low.
                Guess again!
                """;
        String higher = """
                Your guess is too high.
                Guess again!
                """;
        assertEquals(lower, GuessTheNumber.guessResponse(x, y), "Lower test failed.");
        assertEquals(higher, GuessTheNumber.guessResponse(y, x), "Higher test failed.");
    }

    @Test
    void incGuesses() {
        GuessTheNumber.incGuesses();
        assertEquals(1, GuessTheNumber.guesses, "Increase Guesses test 1 failed.");
        GuessTheNumber.incGuesses();
        assertEquals(2, GuessTheNumber.guesses,"Increase Guesses test 2 failed.");
    }

    @Test
    void resetGuesses() {
        GuessTheNumber.incGuesses();
        GuessTheNumber.incGuesses();
        assertEquals(2, GuessTheNumber.guesses, "Increase Guesses failed.");
        GuessTheNumber.resetGuesses();
        assertEquals(0, GuessTheNumber.guesses, "Reset Guesses failed.");
    }
}
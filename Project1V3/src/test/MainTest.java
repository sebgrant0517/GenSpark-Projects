import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {

    @Test
    void caveEntry() {
        String cave1 = """
                    You approach the cave...
                    It is dark and spooky...
                    A large dragon jumps out in front of you! He opens his jaw and...
                    Gobbles you down in one bite!""";
        String cave2 = """
                    You approach the cave...
                    There is a faint glow in the distance...
                    You move deeper into the cave...
                    There is a pile of gold!""";
        assertEquals(cave1, Main.caveEntry(1), "Cave 1 Test Failed.");
        assertEquals(cave2, Main.caveEntry(2), "Cave 2 Test Failed.");
    }
}
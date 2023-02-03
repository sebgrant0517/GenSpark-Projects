import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    private Goblin g;
    @BeforeEach
    void setUp() {
        g = new Goblin();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHealth() {
        for(int x = 0; x < 100; x++){
            assertTrue(g.getHealth() >= 15, "Get Health was below 15.");
            assertTrue(g.getHealth() <= 20, "Get Health was above 20.");
            g = new Goblin();
        }
    }

    @Test
    void setHealth() {
        g.setHealth(20);
        assertEquals(20, g.getHealth(), "Set Health failed in first test.");
        g.setHealth(g.getHealth() - 5);
        assertEquals(15, g.getHealth(), "Set Health failed in second test.");
    }

    @Test
    void getStrength() {
        for(int x = 0; x < 100; x++){
            assertTrue(g.getStrength() >= 10, "Get Strength was below 10.");
            assertTrue(g.getStrength() <= 15, "Get Strength was above 15.");
            g = new Goblin();
        }
    }

    @Test
    void getDrop() {
        Equipment z = new Equipment();
        Equipment drop;
        for(int x = 0; x < 100; x++){
            drop = g.getDrop();
            assertTrue(Objects.isNull(drop) || drop.getClass().equals(z.getClass()), "Get Drop Method failed.");
            g = new Goblin();
        }
    }

    @Test
    void getXCord() {
        for(int x = 0; x < 100; x++){
            assertTrue(g.getXCord() >= 1, "Get X Cord was below 1.");
            assertTrue(g.getXCord() <= 9, "Get X Cord was above 9.");
            g = new Goblin();
        }
    }

    @Test
    void setXCord() {
        g.setXCord(5);
        assertEquals(5, g.getXCord(), "Set X Cord method failed.");
    }

    @Test
    void getYCord() {
        for(int x = 0; x < 100; x++){
            assertTrue(g.getYCord() >= 1, "Get Y Cord was below 1.");
            assertTrue(g.getYCord() <= 9, "Get Y Cord was above 9.");
            g = new Goblin();
        }
    }

    @Test
    void setYCord() {
        g.setYCord(5);
        assertEquals(5, g.getYCord(), "Set Y Cord method failed.");
    }

    @Test
    void testToString() {
        assertEquals("\u0103", g.toString(), "To String method failed.");
    }

    @Test
    void move() {
        Land map = new Land(new Human());
        for(int x = 0; x < 100; x++){
            g.move(map);
            assertTrue(g.getXCord() >= 0, "Get X Cord was below 0.");
            assertTrue(g.getXCord() <= 9, "Get X Cord was above 9.");
            assertTrue(g.getYCord() >= 0, "Get Y Cord was below 0.");
            assertTrue(g.getYCord() <= 9, "Get Y Cord was above 9.");
        }
    }

    @Test
    void attack() {
        Human h = new Human();
        Land map = new Land(h);
        assertTrue(g.attack(h, map), "Attack returned true.");
    }
}
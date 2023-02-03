import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class HumanTest {
    private Human p;
    @BeforeEach
    void setUp() {
        p = new Human();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStrength() {
        assertEquals(10, p.getStrength(), "Get Strength method failed.");
    }

    @Test
    void setStrength() {
        p.setStrength(p.getStrength() + 5);
        assertEquals(15, p.getStrength(), "Set Strength method failed.");
    }

    @Test
    void setHealth() {
        p.setHealth(p.getHealth() - 5);
        assertEquals(30, p.getHealth(), "Set Health method failed.");
    }

    @Test
    void getHealth() {
        assertEquals(35, p.getHealth(), "Get Health method failed.");
    }

    @Test
    void addItem() {
        Equipment e = new Equipment();
        p.addItem(e);
        assertEquals(10 + e.getBonusStrength(), p.getStrength(), "Add Item first test failed.");
        assertEquals(35 + e.getBonusHealth(), p.getHealth(), "Add Item second test failed.");
    }

    @Test
    void getXCord() {
        assertEquals(0, p.getXCord(), "Get X Cord method failed.");
    }

    @Test
    void setXCord() {
        p.setXCord(3);
        assertEquals(3, p.getXCord(), "Set X Cord method failed.");
    }

    @Test
    void getYCord() {
        assertEquals(0, p.getYCord(), "Get Y Cord method failed.");
    }

    @Test
    void setYCord() {
        p.setYCord(3);
        assertEquals(3, p.getYCord(), "Set Y Cord method failed.");
    }

    @Test
    void testToString() {
        assertEquals("\u00B5", p.toString(), "To String method failed.");
    }

    @Test
    void move() {
        Land map = new Land(p);
        p.move("e", map);
        assertEquals(1, p.getYCord(), "Move method first test failed.");
        p.move("e", map);
        assertEquals(2, p.getYCord(), "Move method second test failed.");
        p.move("w", map);
        assertEquals(1, p.getYCord(), "Move method third test failed.");
        p.move("s", map);
        assertEquals(1, p.getXCord(), "Move method fourth test failed.");
        p.move("n", map);
        assertEquals(0, p.getXCord(), "Move method fifth test failed.");
    }

    @Test
    void attack() {
        Goblin g1 = new Goblin();
        Goblin g2 = new Goblin();
        Land map = new Land(p);
        p.setStrength(50);
        assertFalse(p.attack(g1, map));
        p.setStrength(5);
        assertTrue(p.attack(g2, map));
    }
}
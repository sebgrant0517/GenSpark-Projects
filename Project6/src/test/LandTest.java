import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land map;
    Human player;
    Goblin g1;
    ArrayList<Goblin> gobs;
    @BeforeEach
    void setUp() {
        player = new Human();
        map = new Land(player);
        g1 = new Goblin();
        Goblin g2 = new Goblin();
        Goblin g3 = new Goblin();
        gobs = new ArrayList<>();
        gobs.add(g1);
        gobs.add(g2);
        gobs.add(g3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkIfHit() {
        Goblin g = new Goblin(0,0);
        Goblin g2 = new Goblin();
        Goblin g3 = new Goblin();
        Goblin g4 = new Goblin();
        ArrayList<Goblin> gobs2 = new ArrayList<>();
        gobs2.add(g);
        gobs2.add(g2);
        gobs2.add(g3);
        gobs2.add(g4);
        map.updateMap(gobs);
        assertFalse(map.checkIfHit(player), "Check If Hit Player method test 1 failed.");
        map.updateMap(gobs2);
        player.setStrength(5);
        assertTrue(map.checkIfHit(player), "Check If Hit Player method test 2 failed.");
    }

    @Test
    void testCheckIfHit() {
        Goblin g1 = new Goblin(0,0);
        Goblin g2 = new Goblin();
        assertTrue(map.checkIfHit(g1), "Check If Hit Goblin method test 1 failed.");
        assertFalse(map.checkIfHit(g2), "Check If Hit Goblin method test 2 failed.");
    }

    @Test
    void killGob() {
        map.updateMap(gobs);
        map.killGob(g1);
        assertEquals(2, gobs.size(), "Kill Gob method failed.");
    }

    @Test
    void getGobs() {
        map.updateMap(gobs);
        assertEquals(gobs, map.getGobs(), "Get Gobs method failed.");
    }
}
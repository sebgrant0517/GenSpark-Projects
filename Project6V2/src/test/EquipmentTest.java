import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    private Equipment randomWeapon;
    @BeforeEach
    void setUp() {
        randomWeapon = new Equipment();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBonusStrength() {
        for(int x = 0; x < 100; x++){
            assertTrue(randomWeapon.getBonusStrength() >= 1, "Get Bonus Strength was below 1.");
            assertTrue(randomWeapon.getBonusStrength() <= 5, "Get Bonus Strength was above 5.");
            randomWeapon = new Equipment();
        }
    }

    @Test
    void getBonusHealth() {
        for(int x = 0; x < 100; x++){
            assertTrue(randomWeapon.getBonusHealth() >= 5, "Get Bonus Health was below 5.");
            assertTrue(randomWeapon.getBonusHealth() <= 10, "Get Bonus Health was above 10.");
            randomWeapon = new Equipment();
        }
    }

    @Test
    void getEquipName() {
        for(int x = 0; x < 100; x++){
            assertTrue(randomWeapon.getEquipName().equals("Bow") || randomWeapon.getEquipName().equals("Sword") || randomWeapon.getEquipName().equals("Shield"), "Get Equip Name method failed.");
            randomWeapon = new Equipment();
        }
    }

    @Test
    void testToString() {
        for(int x = 0; x < 100; x++){
            String ans = randomWeapon.getEquipName() + ": Strength of " + randomWeapon.getBonusStrength() + ". Health of " + randomWeapon.getBonusHealth() + ".";
            assertEquals(ans, randomWeapon.toString(), "To String method failed.");
            randomWeapon = new Equipment();
        }
    }
}
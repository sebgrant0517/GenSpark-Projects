import java.util.ArrayList;

public class Equipment {
    private int bonusHealth;
    private int bonusStrength;
    private ArrayList<String> names = new ArrayList<>();
    private String equipName;
    public Equipment(){
        bonusHealth = (int)(Math.random() * 6) + 5;
        bonusStrength = (int)(Math.random() * 5) + 1;
        names.add("Sword");
        names.add("Shield");
        names.add("Bow");
        equipName = names.get((int)(Math.random() * 3));
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public String getEquipName() {
        return equipName;
    }
    public String toString(){
        return equipName + ": Strength of " + bonusStrength + ". Health of " + bonusHealth + ".";
    }
}

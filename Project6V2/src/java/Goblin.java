import java.util.Objects;

public class Goblin extends Creature{
    private int strength;
    private int health;
    private Equipment drop;
    private int xCord;
    private int yCord;
    private String utf;
    public Goblin(){
        strength = (int) (Math.random() * 6) + 10;
        health = (int) (Math.random() * 6) + 15;
        xCord = (int)(Math.random() * 9) + 1;
        yCord = (int)(Math.random() * 9) + 1;
        utf = "\u0103";
        if((int) (Math.random() * 11) > 5){
            drop = new Equipment();
        }
    }
    public Goblin(int x, int y){
        strength = (int) (Math.random() * 6) + 10;
        health = (int) (Math.random() * 6) + 15;
        xCord = x;
        yCord = y;
        utf = "\u0103";
        if((int) (Math.random() * 11) > 5){
            drop = new Equipment();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public Equipment getDrop() {
        if(Objects.isNull(drop)){
            System.out.println("The goblin didn't drop an item.");
            return null;
        } else {
            System.out.println("The goblin dropped a " + drop.getEquipName() +
                    "!\nIt adds " + drop.getBonusStrength() + " strength and "
                    + drop.getBonusHealth() + " health.");
            return drop;
        }
    }

    public int getXCord() {
        return xCord;
    }

    public void setXCord(int xCord) {
        this.xCord = xCord;
    }

    public int getYCord() {
        return yCord;
    }

    public void setYCord(int yCord) {
        this.yCord = yCord;
    }

    public String toString(){
        return utf;
    }
    public void move(Land map) {
        boolean valid = false;
        String direction = "";
        int ran = (int)(Math.random() * 4) + 1;
        while (!valid) {
            if (ran == 1 && xCord - 1 >= 0) {
                direction = "n";
                xCord--;
                if(map.checkIfHit(this)){
                    xCord++;
                    if(health > 0) {
                        map.updateMap(this);
                    } else{
                        map.killGob(this);
                    }
                } else {
                    if(health > 0) {
                        map.updateMap(this, direction);
                    } else{
                        map.killGob(this);
                    }
                }
                valid = true;
            } else if (ran == 2 && xCord + 1 < 10) {
                direction = "s";
                xCord++;
                if(map.checkIfHit(this)){
                    xCord--;
                    if(health > 0) {
                        map.updateMap(this);
                    } else{
                        map.killGob(this);
                    }
                } else {
                    if(health > 0) {
                        map.updateMap(this, direction);
                    } else{
                        map.killGob(this);
                    }
                }
                valid = true;
            } else if (ran == 3 && yCord + 1 < 10) {
                direction = "e";
                yCord++;
                if(map.checkIfHit(this)){
                    yCord--;
                    if(health > 0) {
                        map.updateMap(this);
                    } else{
                        map.killGob(this);
                    }
                } else {
                    if(health > 0) {
                        map.updateMap(this, direction);
                    } else{
                        map.killGob(this);
                    }
                }
                valid = true;
            } else if (ran == 4 && yCord - 1 >= 0) {
                direction = "w";
                yCord--;
                if(map.checkIfHit(this)){
                    yCord++;
                    if(health > 0) {
                        map.updateMap(this);
                    } else{
                        map.killGob(this);
                    }
                } else {
                    if(health > 0) {
                        map.updateMap(this, direction);
                    } else{
                        map.killGob(this);
                    }
                }
                valid = true;
            } else {
                ran = (int)(Math.random() * 4) + 1;
            }
        }
    }

    public boolean attack(Human h, Land map){
        System.out.println("A goblin ran into you!");
        int humAttack = (int)(Math.random() * (h.getStrength() + 1)) + (h.getStrength() / 2);
        System.out.println("You hit the goblin for " + humAttack + " damage!");
        this.setHealth(this.getHealth() - humAttack);
        if(this.getHealth() > 0){
            System.out.println("The goblin has " + this.getHealth() + " hit points remaining!");
            int gobAttack = (int)(Math.random() * (this.getStrength() + 1)) + (this.getStrength() / 2);
            System.out.println("The goblin hit you for " + gobAttack + " damage!");
            h.setHealth(h.getHealth() - gobAttack);
            if(h.getHealth() > 0){
                System.out.println("You have " + h.getHealth() + " hit points remaining!");
            } else{
                map.playerDied();
                System.out.println("You died!");
            }
        } else{
            System.out.println("You killed the goblin!");
            map.killGob(this);
            map.updateMap(h);
            h.addItem(this.getDrop());
        }
        return true;
    }
}

import java.util.ArrayList;
import java.util.Objects;

public class Human extends Creature {
    private int strength;
    private int health;
    private ArrayList<Equipment> inventory;
    private int xCord;
    private int yCord;
    private String utf;
    public Human(){
        strength = 10;
        health = 35;
        xCord = 0;
        yCord = 0;
        utf = "\u00B5";
        inventory = new ArrayList<>();
        System.out.println("Your starting health is: " + health + "\nYour starting strength is: " + strength);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void addItem(Equipment item){
        if(!Objects.isNull(item)){
            inventory.add(item);
            setHealth(this.health + item.getBonusHealth());
            setStrength(this.strength + item.getBonusStrength());
        }
    }

    public void checkInventory(){
        System.out.println("Your inventory contains:");
        for(Equipment x : inventory){
            System.out.println(x.toString());
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

    public void move(String direction, Land map){
        boolean valid = false;
        while(!valid) {
            direction = direction.toLowerCase();
            if (direction.equals("n") && xCord - 1 >= 0) {
                xCord--;
                if(map.checkIfHit(this)){
                    xCord++;
                    map.updateMap(this);
                } else {
                    map.updateMap(this, direction);
                }
                valid = true;
            } else if (direction.equals("s") && xCord + 1 < 10) {
                xCord++;
                if(map.checkIfHit(this)){
                    xCord--;
                    map.updateMap(this);
                } else {
                    map.updateMap(this, direction);
                }
                valid = true;
            } else if (direction.equals("e") && yCord + 1 < 10) {
                yCord++;
                if(map.checkIfHit(this)){
                    yCord--;
                    map.updateMap(this);
                } else {
                    map.updateMap(this, direction);
                }
                valid = true;
            } else if (direction.equals("w") && yCord - 1 >= 0) {
                yCord--;
                if(map.checkIfHit(this)){
                    yCord++;
                    map.updateMap(this);
                } else {
                    map.updateMap(this, direction);
                }
                valid = true;
            } else{
                System.out.println("Invalid direction. Try again.");
                direction = Main.s.nextLine();
            }
        }
    }

    public boolean attack(Goblin g, Land map){
        System.out.println("You ran into a goblin!");
        int humAttack = (int)(Math.random() * (this.strength + 1)) + (this.strength / 2);
        System.out.println("You hit the goblin for " + humAttack + " damage!");
        g.setHealth(g.getHealth() - humAttack);
        if(g.getHealth() > 0){
            System.out.println("The goblin has " + g.getHealth() + " hit points remaining!");
            int gobAttack = (int)(Math.random() * (g.getStrength() + 1)) + (g.getStrength() / 2);
            System.out.println("The goblin hit you for " + gobAttack + " damage!");
            this.setHealth(health - gobAttack);
            if(health > 0){
                System.out.println("You have " + health + " hit points remaining!");
            } else{
                map.playerDied();
                System.out.println("You died!");
            }
            return true;
        } else{
            System.out.println("You killed the goblin!");
            map.killGob(g);
            map.updateMap(map.getGobs());
            this.addItem(g.getDrop());
            return false;
        }
    }
}

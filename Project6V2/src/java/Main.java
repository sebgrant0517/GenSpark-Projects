import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        Human player = new Human();
        Land map = new Land(player);
        Goblin gob1 = new Goblin(9,9);
        Goblin gob2 = new Goblin(2,4);
        Goblin gob3 = new Goblin(6,1);
        Goblin gob4 = new Goblin(4,5);
        Goblin gob5 = new Goblin(0,3);
        Goblin gob6 = new Goblin();
        Goblin gob7 = new Goblin();
        ArrayList<Goblin> gobs = new ArrayList<>();
        gobs.add(gob1);
        gobs.add(gob2);
        gobs.add(gob3);
        gobs.add(gob4);
        gobs.add(gob5);
        gobs.add(gob6);
        gobs.add(gob7);
        map.updateMap(player);
        map.updateMap(gobs);
        GUI screen = new GUI(map, player, gobs);
        /*
        System.out.println(map.toString());
        while(!gobs.isEmpty() && player.getHealth() >= 0) {

            for(int a = 0; a < gobs.size(); a++){
                gobs.get(a).move(map);
                if(player.getHealth() <= 0){
                    break;
                }
            }
            System.out.println(map.toString());
        }
        if(player.getHealth() > 0 ){
            System.out.println("You killed all the goblins!");
            player.checkInventory();
        } else{
            System.out.println("What did you collect before passing?");
            player.checkInventory();
        }

         */
    }
}

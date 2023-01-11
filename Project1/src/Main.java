import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\nand will " +
                "share his treasure with you. The other dragon\nis greedy and " +
                "hungry and will eat you on sight.\nWhich cave will you go into? (1 or 2)");
        String answer = s.nextLine();
        while(!answer.equals("1") && !answer.equals("2")){
            answer = s.nextLine();
        }
        if(answer.equals("1")){
            System.out.println("You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens his jaw and...\n" +
                    "Gobbles you down in one bite!");
        }
        if(answer.equals("2")){
            System.out.println("You approach the cave...\n" +
                    "There is a faint glow in the distance...\n" +
                    "You move deeper into the cave...\n" +
                    "There is a pile of gold!");
        }

    }
}
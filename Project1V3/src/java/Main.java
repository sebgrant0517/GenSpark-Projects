import java.util.Scanner;
public class Main {
    public static String caveEntry(int x){
        String cave = "";
        if(x == 1){
            cave = """
                    You approach the cave...
                    It is dark and spooky...
                    A large dragon jumps out in front of you! He opens his jaw and...
                    Gobbles you down in one bite!""";
        } else if(x == 2){
            cave = """
                    You approach the cave...
                    There is a faint glow in the distance...
                    You move deeper into the cave...
                    There is a pile of gold!""";
        }
        return cave;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("""
                You are in a land full of dragons. In front of you,
                you see two caves. In one cave, the dragon is friendly
                and will share his treasure with you. The other dragon
                is greedy and hungry and will eat you on sight.
                Which cave will you go into? (1 or 2)""");
        int answer = 0;
        try {
            answer = s.nextInt();
            while (answer != 1 && answer != 2) {
                answer = s.nextInt();
            }
        } catch(Exception e){
            System.out.println("Caught Exception: Number Format Exception");
        }
        System.out.println(caveEntry(answer));
    }
}
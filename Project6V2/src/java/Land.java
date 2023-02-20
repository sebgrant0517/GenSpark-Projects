import java.util.ArrayList;

public class Land {
    private String[][] map;
    private ArrayList<Goblin> gobs;
    private Human player;

    public Land(Human p){
        map = new String[10][10];
        gobs = new ArrayList<>();
        player = p;
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                map[x][y] = "\u25A1";
            }
        }
    }

    public void updateMap(Creature crt){
        map[crt.getXCord()][crt.getYCord()] = crt.toString();
    }
    public void updateMap(ArrayList<Goblin> goblins){
        gobs = goblins;
        for(Creature crt : gobs) {
            map[crt.getXCord()][crt.getYCord()] = crt.toString();
        }
    }

    public void updateMap(Creature crt, String direction){
        map[crt.getXCord()][crt.getYCord()] = "\u25A1";
        if(direction.equals("n")){
            map[crt.getXCord() + 1][crt.getYCord()] = "\u25A1";
            map[crt.getXCord()][crt.getYCord()] = crt.toString();
        } else if(direction.equals("s")){
            map[crt.getXCord() - 1][crt.getYCord()] = "\u25A1";
            map[crt.getXCord()][crt.getYCord()] = crt.toString();
        } else if(direction.equals("e")){
            map[crt.getXCord()][crt.getYCord() - 1] = "\u25A1";
            map[crt.getXCord()][crt.getYCord()] = crt.toString();
        } else if(direction.equals("w")){
            map[crt.getXCord()][crt.getYCord() + 1] = "\u25A1";
            map[crt.getXCord()][crt.getYCord()] = crt.toString();
        }
    }

    public String toString(){
        StringBuilder ans = new StringBuilder("<html>");
        for(int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                ans.append(map[x][y] + " ");
            }
            ans.deleteCharAt(ans.length() - 1);
            ans.append("<br/>");
        }
        ans.append("</html>");
        String fin = ans.toString();
        return fin;
    }

    public boolean checkIfHit(Human h){
        for(Goblin g : gobs){
            if(g.getXCord() == h.getXCord() && g.getYCord() == h.getYCord()){
                return h.attack(g, this);
            }
        }
        return false;
    }
    public boolean checkIfHit(Goblin g){
            if(g.getXCord() == player.getXCord() && g.getYCord() == player.getYCord()){
                return g.attack(player, this);
            }
        return false;
    }

    public void killGob(Goblin g){
        map[g.getXCord()][g.getYCord()] = "\u25A1";
        gobs.remove(g);
    }

    public void playerDied(){
        map[player.getXCord()][player.getYCord()] = "\u0146";
    }
    public ArrayList<Goblin> getGobs(){
        return gobs;
    }
}

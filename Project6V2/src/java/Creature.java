public class Creature {
    private int xCord;
    private int yCord;
    private String utf;
    public Creature(){
        xCord = 0;
        yCord = 0;
        utf = "Creature";
    }

    public int getXCord() {
        return xCord;
    }

    public void setXCord(int xCord) {
        this.xCord = xCord;
    }

    public void setYCord(int yCord) {
        this.yCord = yCord;
    }

    public int getYCord() {
        return yCord;
    }

    public String toString(){
        return utf;
    }
}

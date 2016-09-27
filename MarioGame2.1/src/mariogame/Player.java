
package mariogame;

public class Player {
    
    private String Name;
    private int life;
    private int rowPos;
    private int colPos;

    public Player(String cName, int clife, int crowPos, int ccolPos) {
        Name = cName;
        life = clife;
        rowPos = crowPos = 0;
        colPos = ccolPos = 0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String sName) {
        Name = sName;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int slife) {
        life = slife;
    }

    public int getRowPos() {
        return rowPos;
    }

    public void setRowPos(int srowPos) {
        rowPos = srowPos;
    }

    public int getColPos() {
        return colPos;
    }

    public void setColPos(int scolPos) {
        colPos = scolPos;
    }

    @Override
    public String toString() {
        return "Player{" + "Name=" + Name + ", life=" + life + ", rowPos=" + rowPos + ", colPos=" + colPos + '}';
    }
    
    
    
    
}

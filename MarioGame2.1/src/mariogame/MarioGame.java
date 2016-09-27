
package mariogame;

import MarioGame.Level;

public class MarioGame {

    public static void main(String[] args) {
        
        Player carlos = new Player ("Carlos", 100, 0, 0);
        Player computer = new Player ("Comp", 1000, 0, 0);
        Level level1 = new Level ();

        level1.gamePlay(carlos, computer);

       
    }
}

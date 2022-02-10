import game.Game;
import game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(500, 500))).start();
        //protoLevel p = new protoLevel();
        //p.setLvlID(1);
        //p.readLevel();
    }
}

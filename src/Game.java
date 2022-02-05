import java.awt.*;

public class Game {
    private Display d;
    private Rectangle rectangle;
    public Game(int width, int height){
        d = new Display(width, height);
        rectangle = new Rectangle(0,0,50,50);
    }
    public void render(){
        d.render(this);
    }
    public void update(){
        rectangle.setLocation((int)rectangle.getX() + 1, (int)rectangle.getY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}

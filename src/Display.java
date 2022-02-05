import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    private Canvas c;
    public Display(int width, int height){
    setTitle("Taistealaí");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    c = new Canvas();
    c.setPreferredSize(new Dimension(width, height));
    c.setFocusable(false);
    add(c);
    pack();

    c.createBufferStrategy(3);

    setLocationRelativeTo(null);
    setVisible(true);
    }
    public void render(Game g){
        BufferStrategy bufferStrategy = c.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, c.getWidth(), c.getHeight());

        Rectangle rectangle = g.getRectangle();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight()
        );

        graphics.dispose();
        bufferStrategy.show();
    }
}

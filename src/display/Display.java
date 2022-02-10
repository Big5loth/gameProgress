package display;

import game.Game;
import input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    private Canvas c;
    private Renderer renderer;
    public Display(int width, int height, Input input){
    setTitle("Taistealaí");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    this.renderer = new Renderer();

    c = new Canvas();
    c.setPreferredSize(new Dimension(width, height));
    c.setFocusable(false);
    add(c);
    addKeyListener(input);
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

        renderer.render(g,graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}

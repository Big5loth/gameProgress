package display;

import game.Game;

import java.awt.*;

public class Renderer {
    public void render(Game g, Graphics graphics){
        g.getGameObjects().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null));
    }
}

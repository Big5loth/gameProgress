package game;

import controller.PlayerController;
import display.Display;
import entity.GameObject;
import entity.Player;
import input.Input;

import java.util.ArrayList;
import java.util.List;
public class Game {
    private Display d;
    private List<GameObject> gameObjects;
    private Input input;
    public Game(int width, int height){
        input = new Input();
        d = new Display(width, height,input);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Player(new PlayerController(input)));
    }
    public void render(){
        d.render(this);
    }
    public void update(){
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}

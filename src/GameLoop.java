public class GameLoop implements Runnable{
    private Game g;
    private boolean running;
    private final double refreshRate = 1.0/60.0d;
    private long nextStatTime;
    private int fps, ups;

    public GameLoop(Game game){
        this.g = game;
    }

    @Override
    public void run(){
        running = true;
        double accumulator = 0;
        long runTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running){
            runTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (runTime - lastUpdate);
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = runTime;

            while (accumulator > refreshRate) {
                update();
                accumulator -= refreshRate;
            }
            render();
            printStats();
        }
    }
    public void printStats(){
        if(System.currentTimeMillis() > nextStatTime){
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }
    public void render(){
        g.render();
        fps++;
    }
    public void update(){
        g.update();
        ups++;
    }
}

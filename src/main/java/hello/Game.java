package hello;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1920, HEIGHT = WIDTH / 12 * 9;
    public static final int scale = 1;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private Environment environment;
    private HUD hud;
    

    public Game() {
        handler = new Handler();
        r = new Random();
        environment = new Environment(WIDTH/scale, HEIGHT/scale, scale, scale);
        //this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Test Game", this);

        //hud = new HUD();

        // handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2 -32, ID.Player, handler));

        handler.addObject(new Turmite(WIDTH/(scale * 2) -200, HEIGHT/(scale * 2)-200, "LRLRLLLLLLLR", ID.Ant, handler, environment));
        // handler.addObject(new Turmite(r.nextInt(WIDTH/scale), r.nextInt(HEIGHT/scale), "LRRL", ID.Ant, handler, environment));
        // handler.addObject(new Ant(r.nextInt(WIDTH/scale), r.nextInt(HEIGHT/scale), ID.Ant, handler, environment));
        
        
        // handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        // handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        // handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        // handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
    }

    private static final long serialVersionUID = 1L;

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        //hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        environment.render(g);
        handler.render(g);
      
        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min,  int max){
        if(var >= max){
            return var = max;
        }
        else if (var <= min){
            return var = min;
        }
        else{
            return var;
        }
    }
    public static void main( String[] args )
    {
        new Game();
    }
}
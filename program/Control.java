import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Control extends JPanel implements Runnable { //control game functions

    //global variable declaration
    final int WIDTH = 500;
    final int HEIGHT = 400;
    final int BALL_DIAMETER = 10;
    final int PADDLE_X = 10;
    final int PADDLE_Y = 50;
    final Dimension WINDOW_SIZE = new Dimension(WIDTH, HEIGHT);

    //initialize game objects
    Thread gameScript;
    Image gameImage;
    Graphics graphics;
    Random rand;
    Paddle p1; //player 1
    Paddle p2; //player 2
    Ball b;
    Score s;

    Control() {
        paddles();
        ball();
        s = new Score(WIDTH, HEIGHT);
        setupGUI();

        gameScript = new Thread(this);
        gameScript.start();
    }

    public void setupGUI () {
        setFocusable(true);
        addKeyListener(new ActionListener());
        setPreferredSize(WINDOW_SIZE);
    }

    public void paddles() { //new paddles
        p1 = new Paddle(5, (HEIGHT/2)-25, PADDLE_X, PADDLE_Y, 1);
        p2 = new Paddle(485, (HEIGHT/2)-25, PADDLE_X, PADDLE_Y, 2);
    }

    public void ball() { //new ball
        rand = new Random();
        b = new Ball((WIDTH/2) - (BALL_DIAMETER/2), (HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void paint (Graphics g) { //paint new page
        gameImage = createImage(getWidth(),getHeight()); //setup image
        graphics = gameImage.getGraphics();
        draw(graphics);
        g.drawImage(gameImage,0,0,this);
    }

    public void draw (Graphics g) { //draw graphics for new page
        p1.draw(g);
        p2.draw(g);
        b.draw(g);
        s.draw(g);
    }

    public void move () { //reset movement
        p1.move();
        p2.move();
        b.move();
    }

    public void collision() { //check for ball collisions
        //if ball hits paddle
        if (b.intersects(p1) || b.intersects(p2)) {
            b.setXDirection(-b.xDir);
        }

        //reset game (game point) & track score
        if (b.x <= 0) {
            s.p2Score++; //incr score
            paddles(); //reset to new components
            ball();
        }
        if (b.x >= 490) {
            s.p1Score++; //incr score
            paddles(); //reset to new components
            ball();
        }
    }

    public void run() { //run game interface
        long time = System.nanoTime(); //set game loop time
        double ticks = 60.0;
        double ns = 1000000000 / ticks;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - time) / ns;
            time = now;
            if (delta >= 1) { //check if loop excess
                move();
                collision();
                repaint();
                delta--;
            }
        }
    }

    public class ActionListener extends KeyAdapter { //user action control
        public void keyPressed (KeyEvent key) {
            p1.keyPressed(key);
            p2.keyPressed(key);
        }

        public void keyReleased (KeyEvent key) {
            p1.keyReleased(key);
            p2.keyReleased(key);
        }
    }
}

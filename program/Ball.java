import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Ball extends Rectangle { //design ball

	//global variables
	Random rand;
	final int speed = 3; //variable based on game time
	int xDir, yDir; //x and y direction moves

	Ball(int x, int y, int w, int h) {
		super (x, y, w, h);
		rand = new Random();

		int randX = rand.nextInt(2); //rand 0 or 1
		if (randX == 0) {
			randX--; //goes to -1
		}
		setXDirection(randX * speed); //ball direction, incr by speed

		int randY = rand.nextInt(2); //rand 0 or 1
		if (randY == 0) {
			randY--; //goes to -1
		}
		setYDirection(randY * speed); //ball direction, incr by speed
	}

	public void setXDirection(int randomX){
		xDir = randomX;
	}

	public void setYDirection(int randomY){
		yDir = randomY;
	}

	public void move() {
		x += xDir;
		y += yDir;
		if (y <= 0 || y >= 390) { //check boundaries
			setYDirection(-yDir);
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}

}
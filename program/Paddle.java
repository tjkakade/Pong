import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle { //design paddles

	//global variables
	final int pSpeed = 5; //speed of paddle movement
	int id; //p1 = 1, p2 = 2
	int ySpeed;
	
	Paddle(int x, int y, int PADDLE_X, int PADDLE_Y, int id) {
		super(x,y,PADDLE_X, PADDLE_Y); //rectangle class
		this.id = id;
	}

	public void keyPressed(KeyEvent key) {
		switch (id) {
			case 1: //p1 up, down
				if (key.getKeyCode() == KeyEvent.VK_W) {
					setYDirection(-pSpeed);
					move();
				}
				if (key.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(pSpeed);
					move();
				}
				break;
			case 2: //p1 up, down
				if (key.getKeyCode() == KeyEvent.VK_UP) {
					setYDirection(-pSpeed);
					move();
				}
				if (key.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(pSpeed);
					move();
				}
				break;
		}
	}

	public void keyReleased(KeyEvent key) {
		switch (id) {
			case 1: //p1 up, down
				if (key.getKeyCode() == KeyEvent.VK_W) {
					setYDirection(0);
					move();
				}
				if (key.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(0);
					move();
				}
				break;
			case 2: //p2 up, down
				if (key.getKeyCode() == KeyEvent.VK_UP) {
					setYDirection(0);
					move();
				}
				if (key.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(0);
					move();
				}
				break;
		}
	}

	public void setYDirection(int yDir) {
		ySpeed = yDir;
	}


	public void move() {
		y += ySpeed; //translate
		if (y <= 0) { //check boundaries
			y = 0;
		}
		if (y >= 350) {
			y = 350;
		}
	}

	public void draw(Graphics g) {
		if (id == 1) { //color set
			g.setColor(Color.cyan);
		}
		else {
			g.setColor(Color.pink);
		}
		g.fillRect(x, y, width, height); //create paddles on screen
	}
}

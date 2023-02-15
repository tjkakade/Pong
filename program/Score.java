import java.awt.*;

public class Score extends Rectangle { //score keeper

    //global variables
    static int WIDTH, HEIGHT; //frame width, height
    int p1Score, p2Score;
    String name1 = "BLUE";
    String name2 = "PINK";

    Score(int WIDTH, int HEIGHT) {
        Score.WIDTH = WIDTH;
        Score.HEIGHT = HEIGHT;
    }

    public void draw (Graphics g) { //display score board
        g.setColor(Color.white);
        g.setFont(new Font("Optima", Font.BOLD, 30));
        g.drawString(String.valueOf(p1Score), (WIDTH/2)-35, 40);
        g.drawString(String.valueOf(p2Score), (WIDTH/2)+20, 40);

        g.setFont(new Font("Optima", Font.PLAIN, 10));
        g.drawString(String.valueOf(name1), (WIDTH/2)-39, 60);
        g.drawString(String.valueOf(name2), (WIDTH/2)+17, 60);
    }
}

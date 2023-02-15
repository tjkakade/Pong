import javax.swing.*;
import java.awt.*;

public class Window extends JFrame { //design of game window

    Control panel;

    Window() {
        setupGUI();
    }

    public void setupGUI () { //initialize the window pane
        panel = new Control(); //transfer control panel
        add(panel);
        setTitle("Pong");
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

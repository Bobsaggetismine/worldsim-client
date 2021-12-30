import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    public BufferedImage image;
    private Thread networkThread;

    public Canvas canvas;

    public Window(){


        networkThread = new Thread(new NetworkListener(this));
        networkThread.start();

        canvas = new Canvas();

        this.add(canvas);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setVisible(true);
    }
    public void render(){
        canvas.repaint();
    }

}

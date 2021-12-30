import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
    public BufferedImage _worldImg = null;


    public Canvas() {
        this.setSize(new Dimension(1280,720));
    }

    public BufferedImage world() {
        return _worldImg;
    }


    public void paintComponent(Graphics g) {
        g.drawImage(_worldImg, 0, 0, null);
    }
}

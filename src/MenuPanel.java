import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    Image backgroundImage;

    public MenuPanel(){
        backgroundImage = new ImageIcon("menu_image.png").getImage();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0 , null);
    }
}

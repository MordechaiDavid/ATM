import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ATM extends JFrame {
    Image icon;

    public ATM(){
        icon = new ImageIcon("ATM_icon.png").getImage();
        Bank bank = null;
        try {
            bank = new Bank();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        LogInPanel logInPanel = new LogInPanel(this, bank);
        this.getContentPane().add(logInPanel);
        this.setTitle("ATM");
        this.setIconImage(icon);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class ATM extends JFrame {
    Image icon;

    public ATM(){
        icon = new ImageIcon("ATM_icon.png").getImage();
        Bank bank = new Bank();
        LogInPanel logInPanel = new LogInPanel(this, bank.getBankAccounts());
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

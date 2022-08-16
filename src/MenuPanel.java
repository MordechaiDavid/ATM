import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class MenuPanel extends JPanel {

    protected final int PANEL_WIDTH = 500;
    protected final int PANEL_HEIGHT = 500;
    protected BankAccount account;
    protected Image backgroundImage;
    protected JLabel balanceLabel;




    public MenuPanel(BankAccount account){
        this.account = account;
        backgroundImage = new ImageIcon("menu_image.png").getImage();

        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00'$'");
        balanceLabel = new JLabel("Your balance - "+decimalFormat.format(account.getBalance()));
        balanceLabel.setBounds(150, 50, 150, 40);
        balanceLabel.setForeground(Color.black);
        account.withdraw(100);
        System.out.println(account.getBalance());

        this.add(balanceLabel);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backgroundImage, 0, 0 , null);
    }
}

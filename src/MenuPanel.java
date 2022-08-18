import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class MenuPanel extends JPanel implements ActionListener {

    protected final int PANEL_WIDTH = 500;
    protected final int PANEL_HEIGHT = 500;
    protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,##0.00'$'");
    protected Bank bank;
    protected BankAccount account;
    protected Image backgroundImage;
    protected JLabel balanceLabel;
    protected JLabel withdrawLabel;
    protected JTextField withdrawFiled;
    protected JButton withdrawButton;


    public MenuPanel(Bank bank, BankAccount account){
        this.bank = bank;
        this.account = account;
        backgroundImage = new ImageIcon("menu_image.png").getImage();

        balanceLabel = new JLabel("Your balance - "+DECIMAL_FORMAT.format(account.getBalance()));
        balanceLabel.setBounds(150, 50, 150, 40);
        balanceLabel.setForeground(Color.black);

        withdrawLabel = new JLabel("withdraw funds:");
        withdrawLabel.setBounds(balanceLabel.getX()+50, balanceLabel.getY()+balanceLabel.getHeight()+50
                                    , 120,40);

        withdrawFiled = new JTextField();
        withdrawFiled.setBounds(withdrawLabel.getX(), withdrawLabel.getY()+withdrawLabel.getHeight()
                                , withdrawLabel.getWidth(), withdrawLabel.getHeight());

        withdrawButton = new JButton("Confirm");
        withdrawButton.setBounds(withdrawFiled.getX(), withdrawFiled.getY()+withdrawFiled.getHeight(),
                withdrawFiled.getWidth(), withdrawFiled.getHeight());
        withdrawButton.addActionListener(this);

        this.add(balanceLabel);
        this.add(withdrawLabel);
        this.add(withdrawFiled);
        this.add(withdrawButton);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backgroundImage, 0, 0 , null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==withdrawButton){
            account.withdraw(Double.parseDouble(withdrawFiled.getText()));
            balanceLabel.setText("Your balance - "+DECIMAL_FORMAT.format(account.getBalance()));
            try {
                bank.updateData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

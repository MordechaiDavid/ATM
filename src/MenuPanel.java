import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class MenuPanel extends JPanel implements ActionListener {

    protected final int PANEL_WIDTH = 500;
    protected final int PANEL_HEIGHT = 400;
    protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,##0.00'$'");
    protected Bank bank;
    protected BankAccount account;
    protected Image backgroundImage;
    protected JLabel balanceLabel;
    protected JButton withdrawButton;
    protected JButton depositButton;


    public MenuPanel(Bank bank, BankAccount account){
        this.bank = bank;
        this.account = account;
        backgroundImage = new ImageIcon("menu_image.jpg").getImage();

        Font balanceFont = new Font("Bernard MT Condensed", Font.ITALIC, 30);

        balanceLabel = new JLabel("Your balance is "+DECIMAL_FORMAT.format(account.getBalance()));
        balanceLabel.setBounds(100, 60, 350, 80);
        balanceLabel.setForeground(Color.black);
        balanceLabel.setFont(balanceFont);

//        withdrawLabel = new JLabel("withdraw funds:");
//        withdrawLabel.setBounds(balanceLabel.getX()+50, balanceLabel.getY()+balanceLabel.getHeight()+50
//                                    , 120,40);

//        withdrawFiled = new JTextField();
//        withdrawFiled.setBounds(withdrawLabel.getX(), withdrawLabel.getY()+withdrawLabel.getHeight()
//                                , withdrawLabel.getWidth(), withdrawLabel.getHeight());

        Font buttonsFont = new Font("Bernard MT Condensed", Font.ITALIC, 17);
        withdrawButton = new JButton("Withdraw funds");
        withdrawButton.setBounds(balanceLabel.getX()-50, balanceLabel.getY()+balanceLabel.getHeight()+70
                                , 150, 60);
        withdrawButton.setFont(buttonsFont);
        withdrawButton.addActionListener(this);

        depositButton = new JButton("Deposit funds");
        depositButton.setBounds(withdrawButton.getX()+withdrawButton.getWidth()+80, withdrawButton.getY(),
                withdrawButton.getWidth(), withdrawButton.getHeight());
        depositButton.addActionListener(this);
        depositButton.setFont(buttonsFont);



        this.add(balanceLabel);
        this.add(withdrawButton);
        this.add(depositButton);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0 , null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // true for withdraw false for deposite
        boolean withOrDepos = false;
        if (e.getSource()==withdrawButton){
            withOrDepos=true;
        }
        else if (e.getSource()==depositButton){
            withOrDepos=false;
        }
        new SubmitFrame(this, account, withOrDepos);
        try {
            bank.updateData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

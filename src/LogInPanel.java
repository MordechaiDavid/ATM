import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LogInPanel extends JPanel implements ActionListener {
    protected final int PANEL_WIDTH = 500;
    protected final int PANEL_HEIGHT = 500;
    protected HashMap<String, String> infoList;
    protected Image backgroundImage;
    protected JLabel IDLabel;
    protected JLabel passwordLabel;
    protected JTextField IDFiled;
    protected JPasswordField passwordField;
    protected JLabel message;
    protected JButton logInButton;

    public LogInPanel(UsersData originalUsersData){
        infoList = originalUsersData.getInfoList();
        backgroundImage = new ImageIcon("bank.png").getImage();
        Font font = new Font(null, Font.ITALIC, 16);
        IDLabel = new JLabel("User ID: ");
        IDLabel.setForeground(Color.black);
        IDLabel.setFont(font);
        IDLabel.setBounds(100, 150, 80, 40);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(font);
        passwordLabel.setBounds(100, IDLabel.getY()+80, 80, 40);

        IDFiled = new JTextField();
        IDFiled.setBounds(IDLabel.getX()+IDLabel.getWidth(), IDLabel.getY(), 100, 40);

        passwordField = new JPasswordField();
        passwordField.setBounds(passwordLabel.getX()+passwordLabel.getWidth(), passwordLabel.getY(), 100, 40);

        logInButton = new JButton("Login");
        logInButton.setFont(font);
        logInButton.setBackground(Color.lightGray);
        logInButton.setBounds(passwordField.getX(), passwordField.getY()+passwordField.getHeight() +40, 100, 40);
        logInButton.addActionListener(this);

        message = new JLabel();
        message.setForeground(Color.green);
        message.setBounds(logInButton.getX(), logInButton.getY()+logInButton.getHeight()+30, 100,40);


        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.add(IDLabel);
        this.add(passwordLabel);
        this.add(IDFiled);
        this.add(passwordField);
        this.add(logInButton);
        this.add(message);
        this.setLayout(null);
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logInButton){
            String ID = IDFiled.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (infoList.containsKey(ID)){
                if (infoList.get(ID).equals(password)) {
                    message.setText("Login successful");
                    System.out.println("df");
                    new MenuPanel();
                }
            }
            else {
                message.setForeground(Color.red);
                message.setText("incorrect ID or password");
            }
        }
    }
}

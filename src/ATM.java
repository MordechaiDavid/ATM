import javax.swing.*;

public class ATM extends JFrame {

    public ATM(){
        UsersData usersData = new UsersData();
        LogInPanel logInPanel = new LogInPanel(usersData);
        this.add(logInPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

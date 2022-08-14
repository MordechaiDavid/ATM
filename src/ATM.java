import javax.swing.*;

public class ATM extends JFrame {

    public ATM(){
        DataUsers dataUsers = new DataUsers();
        LogInPanel logInPanel = new LogInPanel(dataUsers);
        this.add(logInPanel);
        this.setTitle("ATM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

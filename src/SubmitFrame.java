import javax.swing.*;

public class SubmitFrame extends JFrame{

    public SubmitFrame(MenuPanel menuPanel, BankAccount account, boolean withOrDepos){
        this.setSize(300,300);

        JLabel message = new JLabel("Enter the amount");
        message.setBounds(70, 20, 150, 30);

        JTextField textField = new JTextField();
        textField.setBounds(message.getX(), message.getY()+message.getHeight()+5, message.getWidth(), message.getHeight());

        JButton button = new JButton("Confirm");
        button.setBounds(textField.getX(), textField.getY()+textField.getHeight()+5, textField.getWidth(), textField.getHeight());
        button.addActionListener((e -> {
            double amount = Double.parseDouble(textField.getText());
            if (withOrDepos) {
                account.withdraw(amount);
            }
            else {
                try {
                    account.deposit(amount);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            menuPanel.balanceLabel.setText("Your balance is " + MenuPanel.DECIMAL_FORMAT.format(account.getBalance()));
            textField.setText("");
        }));

        this.add(message);
        this.add(textField);
        this.add(button);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }
}

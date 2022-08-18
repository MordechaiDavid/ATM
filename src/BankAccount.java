import java.io.Serializable;

public class BankAccount implements Serializable {
    private String ID;
    private String password;
    private double balance;

    BankAccount(String ID, String password){
        this.ID = ID;
        this.password = password;
        balance = 0;
    }

    public void deposit(double amount) throws Exception {
        double temp = balance-=amount;
        if (temp<=0) throw new Exception("do not have money");
        else balance = temp;
    }

    public void withdraw(double amount){
        balance+=amount;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
}

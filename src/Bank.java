import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private List<BankAccount> bankAccounts;

    public Bank() throws IOException, ClassNotFoundException {
        bankAccounts = new ArrayList<BankAccount>();
        File file = new File("C:\\ATM\\accountsData.dat");
        if (file.exists()){
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("accountsData.dat"));
            bankAccounts = (List<BankAccount>) objectInputStream.readObject();
        }
        else {
            bankAccounts.add(new BankAccount("m", "1"));
            bankAccounts.add(new BankAccount("d", "2"));
        }

    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }


    protected void updateData() throws IOException {
        ObjectOutputStream dataFile = new ObjectOutputStream(new FileOutputStream("accountsData.dat"));
        dataFile.writeObject(bankAccounts);
        dataFile.close();

    }
}

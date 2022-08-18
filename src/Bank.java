import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private HashMap<String, String> usersInfoList;
    private List<BankAccount> bankAccounts;

    public Bank() throws IOException, ClassNotFoundException {
        usersInfoList = usersInfoList = new HashMap<String, String>();
        bankAccounts = new ArrayList<BankAccount>();
        File file = new File("C:\\ATM\\accountsData.dat");
        if (file.exists()){
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("accountsData.dat"));
            bankAccounts = (List<BankAccount>) objectInputStream.readObject();
        }
        else {
            bankAccounts.add(new BankAccount("md", "123"));
            usersInfoList.put(bankAccounts.get(0).getID(), bankAccounts.get(0).getPassword());
            bankAccounts.add(new BankAccount("myd", "456"));
            usersInfoList.put(bankAccounts.get(1).getID(), bankAccounts.get(1).getPassword());
        }

    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    protected HashMap getUsersInfoList(){
        return usersInfoList;
    }

    protected void updateData() throws IOException {
        ObjectOutputStream dataFile = new ObjectOutputStream(new FileOutputStream("accountsData.dat"));
        dataFile.writeObject(bankAccounts);
        dataFile.close();

    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private HashMap<String, String> usersInfoList;
    private List<BankAccount> bankAccounts;

    public Bank(){
        usersInfoList = usersInfoList = new HashMap<String, String>();
        bankAccounts = new ArrayList<BankAccount>();
        bankAccounts.add(new BankAccount("md", "123"));
        usersInfoList.put(bankAccounts.get(0).getID(), bankAccounts.get(0).getPassword());
        bankAccounts.add(new BankAccount("myd", "456"));
        usersInfoList.put(bankAccounts.get(1).getID(), bankAccounts.get(1).getPassword());
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    protected HashMap getUsersInfoList(){
        return usersInfoList;
    }
}

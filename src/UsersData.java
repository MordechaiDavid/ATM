import java.util.HashMap;

public class UsersData {
    private HashMap<String, String> infoList = new HashMap<String, String>();

    public UsersData(){
        infoList.put("md", "123");
        infoList.put("MorYudaDavid", "Myd897");
    }
    protected HashMap getInfoList(){
        return infoList;
    }
}

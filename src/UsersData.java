import java.util.HashMap;
import java.util.Stack;

public class UsersData {
    private HashMap<String, String> infoList = new HashMap<String, String>();

    public UsersData(){
        infoList.put("MordeDavid", "MD18");
        infoList.put("MorYudaDavid", "Myd897");
    }
    protected HashMap getInfoList(){
        return infoList;
    }
}

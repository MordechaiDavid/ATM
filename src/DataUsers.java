import java.util.HashMap;

public class DataUsers {
    private HashMap<String, String> infoList = new HashMap<String, String>();

    public DataUsers(){
        infoList.put("MordeDavid", "MD18");
        infoList.put("MorYudaDavid", "Myd897");
    }
    protected HashMap getInfoList(){
        return infoList;
    }
}

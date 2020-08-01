package controller.request;

import java.util.HashMap;

public class AddCardRequest extends Request {


    private String userName;
    private HashMap<String,Integer> usesMap;


    public AddCardRequest(String userName, HashMap<String, Integer> usesMap) {
        this.userName = userName;
        this.usesMap = usesMap;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HashMap<String, Integer> getUsesMap() {
        return usesMap;
    }

    public void setUsesMap(HashMap<String, Integer> usesMap) {
        this.usesMap = usesMap;
    }
}

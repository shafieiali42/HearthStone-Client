package controller.request;

import controller.response.GoToFirstThreeCardPageResponse;
import controller.response.Response;

public class SetPlayerInfoPassiveRequest extends Request {


    private String userName;
    private int numberOfPassive;

    public SetPlayerInfoPassiveRequest(String userName,int numberOfPassive) {
        this.userName = userName;
        this.numberOfPassive=numberOfPassive;
    }


    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getNumberOfPassive() {
        return numberOfPassive;
    }

    public void setNumberOfPassive(int numberOfPassive) {
        this.numberOfPassive = numberOfPassive;
    }
}

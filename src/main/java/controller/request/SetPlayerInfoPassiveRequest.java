package controller.request;

import controller.response.GoToFirstThreeCardPageResponse;
import controller.response.Response;

public class SetPlayerInfoPassiveRequest extends Request {

    private int numberOfPassive;

    public SetPlayerInfoPassiveRequest(String userName,int numberOfPassive) {
        setUserName(userName);
        setRequestType("SetPlayerInfoPassiveRequest");
        this.numberOfPassive=numberOfPassive;
    }


    public int getNumberOfPassive() {
        return numberOfPassive;
    }

    public void setNumberOfPassive(int numberOfPassive) {
        this.numberOfPassive = numberOfPassive;
    }
}

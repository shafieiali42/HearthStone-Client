package controller.request;

import java.util.HashMap;

public class LeftClickRequest extends Request {


    private String cardName;
    private boolean isLock;

    public LeftClickRequest(String userName, String cardName, boolean isLock) {
        setUserName(userName);
        setRequestType("LeftClickRequest");
        this.cardName = cardName;
        this.isLock = isLock;
    }



    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }


}


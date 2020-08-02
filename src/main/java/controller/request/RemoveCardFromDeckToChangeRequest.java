package controller.request;

import java.util.HashMap;

public class RemoveCardFromDeckToChangeRequest extends Request {


    private String userName;
    private String cardName;


    public RemoveCardFromDeckToChangeRequest(String userName, String cardName) {
        this.userName = userName;
        this.cardName=cardName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

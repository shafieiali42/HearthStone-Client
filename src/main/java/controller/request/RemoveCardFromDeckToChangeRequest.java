package controller.request;

import java.util.HashMap;

public class RemoveCardFromDeckToChangeRequest extends Request {


    private String cardName;


    public RemoveCardFromDeckToChangeRequest(String userName, String cardName) {
        setUserName(userName);
        setRequestType("RemoveCardFromDeckToChangeRequest");
        this.cardName=cardName;
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

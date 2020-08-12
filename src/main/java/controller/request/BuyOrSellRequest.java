package controller.request;

public class BuyOrSellRequest extends Request {


    private String cardName;

    public BuyOrSellRequest(String userName, String cardName) {
        setUserName(userName);
        setRequestType("BuyOrSellRequest");
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

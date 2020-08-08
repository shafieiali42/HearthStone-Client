package controller.request;

public class TransactionRequest extends Request {


    private String cardName;

    public TransactionRequest(String userName, String cardName) {
        setUserName(userName);
        setRequestType("TransactionRequest");
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

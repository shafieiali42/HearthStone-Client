package controller.request;

public class TransactionRequest extends Request {


    private String userName;
    private String cardName;

    public TransactionRequest(String userName, String cardName) {
        this.userName = userName;
        this.cardName = cardName;
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
